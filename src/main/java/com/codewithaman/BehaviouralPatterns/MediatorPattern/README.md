# 🎯 **Mediator Design Pattern**

| 🔧                     | Details                                                                             |
| ---------------------- | ----------------------------------------------------------------------------------- |
| **Type**               | Behavioral Pattern                                                                  |
| **Problem Solved**     | Avoid **tight coupling** between objects communicating with each other              |
| **Real World Analogy** | **Air Traffic Controller** 🛫 — All airplanes communicate **via ATC**, not directly |
| **Also Known As**      | Controller Pattern                                                                  |

---

## 📦 **Core Idea**

> Let a **mediator object** handle communication between components so that components are **not directly dependent** on each other.

---

# 📊 **UML Diagram**

```plaintext
+-------------------+      +----------------+      +----------------+      +----------------+
|     Mediator      |<-----|   Colleague A  |      |   Colleague B  |      |   Colleague C  |
+-------------------+      +----------------+      +----------------+      +----------------+
| + notify()        |          ^                           ^                          ^
| + send()          |          |                           |                          |
+-------------------+    +-------------+            +-------------+           +-------------+
                         |    Colleague Interface   (send/receive methods)              |
```

---

# 📱 **Real-World Example: Chat Room**

> Multiple users are part of a **chatroom** 🗣️
> When one sends a message, the **ChatRoom mediator** handles the delivery to other users.

---

## 👨‍💻 **Java Implementation**

### 1️⃣ Mediator Interface

```java
interface ChatMediator {
    void sendMessage(String message, User user);
    void registerUser(User user);
}
```

---

### 2️⃣ Concrete Mediator

```java
import java.util.ArrayList;
import java.util.List;

class ChatRoom implements ChatMediator {
    private List<User> users = new ArrayList<>();

    @Override
    public void registerUser(User user) {
        users.add(user);
    }

    @Override
    public void sendMessage(String message, User sender) {
        for (User u : users) {
            if (u != sender) {
                u.receive(message, sender);
            }
        }
    }
}
```

---

### 3️⃣ Colleague (User)

```java
abstract class User {
    protected ChatMediator mediator;
    protected String name;

    public User(ChatMediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    public abstract void send(String message);
    public abstract void receive(String message, User sender);
}
```

---

### 4️⃣ Concrete User

```java
class ChatUser extends User {
    public ChatUser(ChatMediator mediator, String name) {
        super(mediator, name);
    }

    @Override
    public void send(String message) {
        System.out.println(this.name + " sends: " + message);
        mediator.sendMessage(message, this);
    }

    @Override
    public void receive(String message, User sender) {
        System.out.println(this.name + " receives from " + sender.name + ": " + message);
    }
}
```

---

### 5️⃣ Demo

```java
public class MediatorPatternDemo {
    public static void main(String[] args) {
        ChatMediator chatRoom = new ChatRoom();

        User aman = new ChatUser(chatRoom, "Aman");
        User sachin = new ChatUser(chatRoom, "Sachin");
        User vikas = new ChatUser(chatRoom, "Vikas");

        chatRoom.registerUser(aman);
        chatRoom.registerUser(sachin);
        chatRoom.registerUser(vikas);

        aman.send("Hello everyone!");
        sachin.send("Hi Aman!");
    }
}
```

---

# 📊 Output

```
Aman sends: Hello everyone!
Sachin receives from Aman: Hello everyone!
Vikas receives from Aman: Hello everyone!

Sachin sends: Hi Aman!
Aman receives from Sachin: Hi Aman!
Vikas receives from Sachin: Hi Aman!
```

---

# 🧠 **When to Use Mediator Pattern**

✅ When multiple components interact in complex ways  
✅ When you want to **reduce tight coupling**  
✅ When components need **centralized coordination**  

---

# 💪 Benefits

* ✅ Promotes **loose coupling**  
* ✅ Centralized control & orchestration  
* ✅ Easy to **extend and maintain**  
* ✅ Great for **chat apps, UI frameworks, traffic controllers**  

---

# ⚠ Disadvantages

* Can become **monolithic** if mediator becomes too large  
* Single point of failure if not designed carefully  

---

## 🔥 MAANG-Level System Design Use Case: **Air Traffic Control System**

### 🎯 Problem Statement

* Multiple aircrafts flying in the air
* **Air Traffic Controller (ATC)** manages take-off, landing, altitude coordination
* Aircrafts should not talk to each other directly!

---

## 🖼 UML Diagram

```plaintext
+----------------------+
|      ATC Mediator    |
+----------------------+
| + registerFlight()   |
| + notifyFlights()    |
| + updateFlightData() |
+----------------------+
        ▲      ▲       ▲
        |      |       |
+--------+  +--------+ +--------+
|Flight 1|  |Flight 2| |Flight 3|
+--------+  +--------+ +--------+
```

---

## 👨‍💻 Java Sketch

```java
interface ATCMediator {
    void registerFlight(Flight flight);
    void notifyFlights(String msg, Flight sender);
}
```

```java
class ATC implements ATCMediator {
    List<Flight> flights = new ArrayList<>();

    public void registerFlight(Flight f) {
        flights.add(f);
    }

    public void notifyFlights(String msg, Flight sender) {
        for (Flight f : flights) {
            if (f != sender) {
                f.receive(msg);
            }
        }
    }
}
```

```java
abstract class Flight {
    protected String flightId;
    protected ATCMediator mediator;

    public Flight(String id, ATCMediator mediator) {
        this.flightId = id;
        this.mediator = mediator;
    }

    public abstract void send(String msg);
    public abstract void receive(String msg);
}
```

```java
class Airplane extends Flight {
    public Airplane(String id, ATCMediator mediator) {
        super(id, mediator);
    }

    public void send(String msg) {
        System.out.println(flightId + " sending: " + msg);
        mediator.notifyFlights(msg, this);
    }

    public void receive(String msg) {
        System.out.println(flightId + " received: " + msg);
    }
}
```

---

## 🧪 Main Driver

```java
public class ATCDemo {
    public static void main(String[] args) {
        ATCMediator atc = new ATC();

        Flight flight1 = new Airplane("AI-101", atc);
        Flight flight2 = new Airplane("BA-202", atc);
        Flight flight3 = new Airplane("QF-303", atc);

        atc.registerFlight(flight1);
        atc.registerFlight(flight2);
        atc.registerFlight(flight3);

        flight1.send("Requesting landing");
        flight2.send("Holding pattern at 3000ft");
    }
}
```

---

# 📊 Output

```
AI-101 sending: Requesting landing
BA-202 received: Requesting landing
QF-303 received: Requesting landing

BA-202 sending: Holding pattern at 3000ft
AI-101 received: Holding pattern at 3000ft
QF-303 received: Holding pattern at 3000ft
```

---

# ⚙️ Scaling with Mediator in System Design

| Problem                     | Scalable Solution                              |
| --------------------------- | ---------------------------------------------- |
| Central mediator overload   | Use **multiple mediators** per domain/module   |
| Communication delays        | Use **async queues**, thread pools             |
| Real-time sync needed       | Use **WebSockets**, event buses (Redis, Kafka) |
| Distributed mediator needed | Use **microservices** + **service registry**   |

---

# 🧪 Bonus: Mediator in UI Design Systems

| Component  | Without Mediator                 | With Mediator                          |
| ---------- | -------------------------------- | -------------------------------------- |
| Button     | Knows about dropdowns and labels | Just tells mediator it was clicked     |
| Dropdown   | Talks to listbox, button, label  | Only communicates via mediator         |
| UI Changes | Hard to maintain, test, extend   | Simple, centralized event coordination |

✅ Used in frameworks like JavaFX, Android Jetpack Compose, React's useReducer()

---

# 🔍 Mediator vs Observer Pattern

| Feature             | **Mediator**                               | **Observer**                                    |
| ------------------- | ------------------------------------------ | ----------------------------------------------- |
| Interaction Pattern | Colleagues via central **mediator**        | Publisher → multiple **observers**              |
| Communication       | Two-way, coordinated                       | One-way, event-driven                           |
| Coupling            | Reduces direct coupling between colleagues | Observers are still dependent on Subject        |
| Use Case            | UI coordination, chat rooms                | Event handling, notifications                   |
| Scalability         | Less scalable, unless distributed          | Can scale well using Pub/Sub                    |
| Real-World Examples | Chat app, ATC, smart home hubs             | Email alerts, app events, Kafka, message queues |

---

# 🏁 Summary

✅ Use **Mediator** when multiple objects need to interact **indirectly**  
✅ Use **Observer** when changes in one object should notify others  
✅ In **system design**, mediator = **central controller** (like ATC, Notification Center)  
✅ In **event-driven systems**, prefer **Observer → Pub/Sub** with messaging systems (Kafka, SNS, etc.)  

---
