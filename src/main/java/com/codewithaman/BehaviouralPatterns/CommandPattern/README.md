# 🧠 **Command Design Pattern**

| 🔧                     | Details                                                                             |
| ---------------------- | ----------------------------------------------------------------------------------- |
| **Type**               | Behavioral Pattern                                                                  |
| **Problem Solved**     | Encapsulate a **request as an object**, allowing us to parameterize clients & queue |
| **Real World Analogy** | A **TV Remote**: You press a button (command), and the remote sends the command     |
| **Also Known As**      | Action, Transaction                                                                 |

---

## 🎯 **Intent**

> Decouple the object that **invokes** an operation from the one that **performs** it.

---

# 📦 **Core Idea**

* Wrap each action into a **command object** 🧱
* Decouple sender from receiver
* Enable features like **undo**, **redo**, **queue**, and **logging**

---

# 📊 **UML Diagram**

```plaintext
+------------------+
|   Command        |<-------------------+
+------------------+                    |
| + execute()      |                    |
+------------------+                    |
       ▲                               |
       |                               |
+--------------------+         +-------------------+
| LightOnCommand     |         | LightOffCommand    |
+--------------------+         +-------------------+
| + execute()        |         | + execute()       |
+--------------------+         +-------------------+

       ▲
       |
+------------------+         invokes
|    RemoteControl | --------------------->  execute()
+------------------+
| + setCommand()   |
| + pressButton()  |
+------------------+

       ▼
+------------------+
|     Receiver     |  (Light, Fan, etc.)
+------------------+
| + turnOn()       |
| + turnOff()      |
+------------------+
```

---

# 💡 **Real-World Example: Smart Home Remote**

* You click a button → Remote sends a command → Light turns on/off
* Button knows **what command to execute**, not how it works internally

---

## 👨‍💻 **Java Implementation**

### 1️⃣ **Command Interface**

```java
interface Command {
    void execute();
}
```

---

### 2️⃣ **Receiver Class**

```java
class Light {
    public void turnOn() {
        System.out.println("💡 Light is ON");
    }

    public void turnOff() {
        System.out.println("💡 Light is OFF");
    }
}
```

---

### 3️⃣ **Concrete Commands**

```java
class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.turnOn();
    }
}

class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.turnOff();
    }
}
```

---

### 4️⃣ **Invoker (Remote Control)**

```java
class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}
```

---

### 5️⃣ **Client Code (Main)**

```java
public class CommandPatternDemo {
    public static void main(String[] args) {
        Light livingRoomLight = new Light();

        Command onCommand = new LightOnCommand(livingRoomLight);
        Command offCommand = new LightOffCommand(livingRoomLight);

        RemoteControl remote = new RemoteControl();

        remote.setCommand(onCommand);
        remote.pressButton();  // 💡 Light is ON

        remote.setCommand(offCommand);
        remote.pressButton();  // 💡 Light is OFF
    }
}
```

---

## 📊 Output

```
💡 Light is ON  
💡 Light is OFF
```

---

# 🔥 **When to Use Command Pattern**

✅ When you want to **queue, undo, or log requests**  
✅ When different **senders and receivers** shouldn't be tightly coupled  
✅ When operations need to be **parameterized**  

---

# ✅ Real-World Use Cases

| Scenario                    | Command Pattern Use                    |
| --------------------------- | -------------------------------------- |
| UI Buttons (Undo/Redo)      | Each button maps to a command          |
| Text Editor                 | Each action = command (typed, deleted) |
| Transaction Queues          | Retryable commands stored in DB        |
| Smart Home Automation       | Commands like turn on light, AC, fan   |
| Task Scheduling / Cron Jobs | Wrap logic in command object           |

---

# 🏗️ **System Design Scenario: Job Scheduler**

---

## 🎯 Problem Statement

> Design a system that supports **scheduling**, **executing**, and **retrying** of tasks like:
>
> * Email sending
> * Report generation
> * Payment retries

✅ Tasks must be decoupled and stored in queues

---

### ✅ Apply Command Pattern

| Component     | Class                        |
| ------------- | ---------------------------- |
| Command       | `JobCommand` interface       |
| Concrete Cmds | `EmailJob`, `ReportJob`, etc |
| Invoker       | `Scheduler`                  |
| Receiver      | Services (EmailService, etc) |

---

## 👨‍💻 Sample Command Setup

```java
interface JobCommand {
    void execute();
}

class EmailJob implements JobCommand {
    private String recipient;

    public EmailJob(String recipient) {
        this.recipient = recipient;
    }

    public void execute() {
        System.out.println("📧 Email sent to " + recipient);
    }
}

class ReportJob implements JobCommand {
    public void execute() {
        System.out.println("📄 Report Generated");
    }
}
```

---

### Invoker

```java
class JobScheduler {
    private Queue<JobCommand> jobQueue = new LinkedList<>();

    public void addJob(JobCommand job) {
        jobQueue.add(job);
    }

    public void processJobs() {
        while (!jobQueue.isEmpty()) {
            jobQueue.poll().execute();
        }
    }
}
```

---

### Main (Client)

```java
public class JobSchedulerDemo {
    public static void main(String[] args) {
        JobScheduler scheduler = new JobScheduler();

        scheduler.addJob(new EmailJob("aman@example.com"));
        scheduler.addJob(new ReportJob());

        scheduler.processJobs();
    }
}
```

---

## 📊 Output

```
📧 Email sent to aman@example.com  
📄 Report Generated
```

---

# 🧠 **Benefits of Command Pattern**

✅ Decouples **sender and receiver**  
✅ Easy to add **undo/redo**  
✅ Allows for **logging and replay**  
✅ **Parameterizable**, **queueable**, and **serializable**  

---

# ⚠ Disadvantages

❌ Adds **boilerplate code** (many small classes)  
❌ Too many commands = maintenance complexity  

---

# 🧪 Advanced Extensions

| Feature             | Implementation Idea              |
| ------------------- | -------------------------------- |
| Undo / Redo         | Maintain command history stack   |
| Delayed Execution   | Queue commands with timestamps   |
| Retry Logic         | Wrap commands with retry wrapper |
| Audit Trail         | Log command before executing     |
| Command Persistence | Serialize commands in DB         |

---

# 🔁 **Command vs Strategy vs Observer**

| Aspect        | **Command**                       | **Strategy**                            | **Observer**                        |
| ------------- | --------------------------------- | --------------------------------------- | ----------------------------------- |
| Purpose       | Encapsulate request as object     | Encapsulate interchangeable algorithm   | Notify observers on state change    |
| Focus         | **Invoker → Receiver** decoupling | Pluggable behavior                      | One-to-many notification            |
| Use Case      | Undo, queue, remote control       | Fare logic, payment method, AI behavior | Notifications, reactive programming |
| Communication | Sender → Command → Receiver       | Context → Strategy                      | Subject → Observers                 |

---

# 💥 MAANG Interview Tips

✅ Explain with remote control / job scheduler analogy  
✅ Mention benefits: **undo, retry, queue, log**  
✅ Say it promotes **Open/Closed Principle**  
✅ Useful in **transactional & distributed systems**  
✅ Combine with other patterns (Factory, Composite)  

---

# 🔥 Real-World Scenarios

| System                     | Command Use Case                    |
| -------------------------- | ----------------------------------- |
| Text Editor                | Undo/Redo typing                    |
| Game Engine                | Player commands (move, jump, shoot) |
| Database Transaction Queue | Retry DB commands on failure        |
| Email Campaign System      | Queue and retry send commands       |
| Microservice Orchestrator  | Step-wise retryable service calls   |

---

# ✅ Summary

* **Command Pattern** = encapsulate operations as objects  
* Perfect for **undo, redo, queuing, logging**  
* Used in **UI frameworks, job schedulers, remote control systems**  
* Adds flexibility and testability  
* Can scale into **message-driven architectures** with **Kafka, RabbitMQ**  

---


