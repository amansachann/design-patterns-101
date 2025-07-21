# 🛡️ **Proxy Design Pattern**

| 🔧                     | Details                                                                   |
| ---------------------- | ------------------------------------------------------------------------- |
| **Type**               | Structural Pattern                                                        |
| **Problem Solved**     | Provide a **placeholder** or **surrogate** to control access to an object |
| **Real-World Analogy** | 🧑‍💼 Assistant helps control access to a busy CEO                        |
| **Also Known As**      | Surrogate, Placeholder Pattern                                            |

---

## 🎯 **Intent**

> Provide a surrogate or placeholder to control access to an object.

---

## 📦 **Core Idea**

* Client interacts with **proxy** instead of real object
* Proxy can perform **extra actions** (e.g., logging, access control, caching)
* Actual object may be expensive to create or external (e.g., network/db)

---

# 📊 **UML Diagram**

```plaintext
+-------------+
|  Subject    |<--------------------------+
+-------------+                           |
| + request() |                           |
+-------------+                           |
      ▲                                    |
+-------------+        +------------------+
| RealSubject |        |     Proxy        |
+-------------+        +------------------+
| + request() |        | - realSubject    |
+-------------+        | + request()      |
                       +------------------+
```

---

## 💡 **Real-World Analogy**

| Scenario         | Proxy Role                                            |
| ---------------- | ----------------------------------------------------- |
| Bank ATM         | Proxy to the actual bank system                       |
| Virtual Proxy    | Load object only when needed (e.g., image thumbnails) |
| Protection Proxy | Control access (user roles, permissions)              |
| Smart Proxy      | Add logging, performance monitoring, caching          |

---

## 👨‍💻 Java Example: Internet Access Proxy 🌐

---

### 1️⃣ Subject Interface

```java
public interface Internet {
    void connectTo(String serverHost) throws Exception;
}
```

---

### 2️⃣ Real Subject

```java
public class RealInternet implements Internet {
    public void connectTo(String serverHost) {
        System.out.println("✅ Connecting to " + serverHost);
    }
}
```

---

### 3️⃣ Proxy

```java
import java.util.*;

public class ProxyInternet implements Internet {
    private Internet realInternet = new RealInternet();
    private static List<String> bannedSites;

    static {
        bannedSites = Arrays.asList("abc.com", "xyz.com");
    }

    public void connectTo(String serverHost) throws Exception {
        if (bannedSites.contains(serverHost.toLowerCase())) {
            throw new Exception("❌ Access Denied to " + serverHost);
        }
        realInternet.connectTo(serverHost);
    }
}
```

---

### 🧪 Demo

```java
public class ProxyDemo {
    public static void main(String[] args) {
        Internet net = new ProxyInternet();
        try {
            net.connectTo("google.com");
            net.connectTo("abc.com"); // Blocked site
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
```

---

## 🖨️ Output

```
✅ Connecting to google.com
❌ Access Denied to abc.com
```

---

## ✅ When to Use Proxy Pattern

| Scenario                       | Why Use Proxy                                |
| ------------------------------ | -------------------------------------------- |
| Expensive objects              | Delay loading until needed (virtual proxy)   |
| Security or permissions needed | Restrict access (protection proxy)           |
| Logging or monitoring          | Add behavior before/after real operation     |
| Remote communication           | Use a local proxy to represent remote object |

---

## 🔌 System Design Use Cases

| Component                   | Proxy Use                                |
| --------------------------- | ---------------------------------------- |
| Remote Services (RMI, RPC)  | Remote Proxy                             |
| Database Access             | Access control, connection pooling proxy |
| Virtual Images (UI)         | Load images only when needed             |
| API Gateway (Microservices) | Act as proxy for downstream services     |

---

## 🧠 Proxy vs Decorator vs Adapter

| Pattern       | Purpose          | Relation with Real Object         |
| ------------- | ---------------- | --------------------------------- |
| **Proxy**     | Control access   | Controls, delays or restricts use |
| **Decorator** | Add new behavior | Enhances behavior dynamically     |
| **Adapter**   | Match interfaces | Converts interface, not behavior  |

---

## ✅ Pros & Cons

| ✅ Advantages                          | ❌ Disadvantages                |
| ------------------------------------- | ------------------------------ |
| Lazy initialization                   | More classes to maintain       |
| Access control                        | Adds indirection               |
| Logging, monitoring, caching possible | Complexity for small use cases |
| Protect sensitive or costly objects   | Performance may be impacted    |

---

## 🧠 Interview Tips

✅ Explain **intent** (access control, performance, or protection)<br>
✅ Give **real-world examples** like ATM, firewall, or remote proxy<br>
✅ Show how proxy **differs from decorator & adapter**<br>
✅ Mention use in **API Gateways, RMI, lazy loading**<br>
✅ Talk about types: Virtual, Protection, Remote, Smart Proxies

---

# 🏁 Summary

✅ **Proxy = gatekeeper** to real objects  
✅ Used to restrict, delay, monitor or represent real object  
✅ Excellent for **security**, **caching**, **lazy loading**, or **remote calls**  
✅ Common in system design patterns like **API gateways**, **image loaders**, **RMI**  

