# 🔗 **Chain of Responsibility Design Pattern**

| 🔧                     | Details                                                                 |
| ---------------------- | ----------------------------------------------------------------------- |
| **Type**               | Behavioral Pattern                                                      |
| **Problem Solved**     | Avoid coupling sender and receiver by passing requests along a chain    |
| **Real-World Analogy** | 📞 Customer support: escalate calls from level 1 → level 2 → supervisor |

---

## 🎯 **Intent**

> Give multiple objects a chance to handle the request by chaining the receivers.

---

## 📦 **Core Idea**

* Chain objects that can handle a request
* Each object decides to handle or pass to next
* Reduces tight coupling between sender and receiver

---

# 📊 **UML Diagram**

```plaintext
    +-----------------+
    |   Handler       |
    +-----------------+
    | +setNext()      |
    | +handleRequest()|
    +-----------------+
            ^
            |
+------------------------+
| ConcreteHandlerA       |
+------------------------+
| +handleRequest()       |
+------------------------+
            ^
            |
+------------------------+
| ConcreteHandlerB       |
+------------------------+

Client --> HandlerA --> HandlerB --> HandlerC
```

---

## 💡 **Real-World Analogy**

| Scenario          | Handler Chain                            |
| ----------------- | ---------------------------------------- |
| Tech Support      | Level 1 → Level 2 → Supervisor           |
| Leave Approval    | Team Lead → Manager → Director           |
| Logging Framework | ConsoleLogger → FileLogger → EmailLogger |

---

## 👨‍💻 Java Example: Leave Approval System 📝

---

### 1️⃣ Handler Interface

```java
interface LeaveHandler {
    void setNext(LeaveHandler next);
    void handleRequest(int days);
}
```

---

### 2️⃣ Concrete Handlers

```java
class TeamLead implements LeaveHandler {
    private LeaveHandler next;

    public void setNext(LeaveHandler next) {
        this.next = next;
    }

    public void handleRequest(int days) {
        if (days <= 3) {
            System.out.println("✅ Approved by Team Lead");
        } else if (next != null) {
            next.handleRequest(days);
        }
    }
}
```

```java
class Manager implements LeaveHandler {
    private LeaveHandler next;

    public void setNext(LeaveHandler next) {
        this.next = next;
    }

    public void handleRequest(int days) {
        if (days <= 7) {
            System.out.println("✅ Approved by Manager");
        } else if (next != null) {
            next.handleRequest(days);
        }
    }
}
```

```java
class Director implements LeaveHandler {
    public void setNext(LeaveHandler next) {
        // end of chain
    }

    public void handleRequest(int days) {
        if (days <= 15) {
            System.out.println("✅ Approved by Director");
        } else {
            System.out.println("❌ Leave request denied: Too many days");
        }
    }
}
```

---

### 3️⃣ Demo

```java
public class LeaveRequestDemo {
    public static void main(String[] args) {
        LeaveHandler lead = new TeamLead();
        LeaveHandler manager = new Manager();
        LeaveHandler director = new Director();

        lead.setNext(manager);
        manager.setNext(director);

        lead.handleRequest(2);  // TeamLead
        lead.handleRequest(5);  // Manager
        lead.handleRequest(12); // Director
        lead.handleRequest(20); // Denied
    }
}
```

---

## 📦 Output

```
✅ Approved by Team Lead
✅ Approved by Manager
✅ Approved by Director
❌ Leave request denied: Too many days
```

---

# ✅ When to Use Chain of Responsibility

| Scenario                                 | Benefit                      |
| ---------------------------------------- | ---------------------------- |
| Multiple possible handlers for a request | Decouple sender and receiver |
| Dynamic handler change is needed         | Easy to add/remove handlers  |
| Requests follow an escalation path       | Clear control flow           |

---

# 🚀 System Design Use Cases

| System                 | Chain of Responsibility Role                    |
| ---------------------- | ----------------------------------------------- |
| Logging Framework      | Chain loggers: debug → info → warn → error      |
| Authentication         | Chain of auth methods: password → OTP → captcha |
| Technical Support Desk | L1 support → L2 → L3 → Supervisor               |
| Middleware             | Process HTTP request via chained handlers       |

---

# ✅ Pros & Cons

| ✅ Advantages                        | ❌ Disadvantages                      |
| ----------------------------------- | ------------------------------------ |
| Reduces coupling between components | No guarantee of handler handling req |
| Flexible & reusable handler objects | Debugging can be tricky              |
| Promotes Open/Closed principle      | Performance hit if long chains       |

---

# 🧠 Interview Tips

✅ Emphasize **decoupling sender and receiver**<br>
✅ Show how handlers can be added/removed easily<br>
✅ Explain scenarios like **support escalation**, **approval chains**<br>
✅ Mention integration with **logging**, **event pipelines**

---

# 🏁 Summary

✅ Chain of Responsibility = Chain of handlers passing requests 🔗<br>
✅ Avoids `if-else`/`switch` in the client code<br>
✅ Great for **approval systems**, **middleware**, **logging**<br>
✅ Promotes **clean, extensible, decoupled architecture**

---
