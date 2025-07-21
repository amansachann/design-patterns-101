# 🧠 **Singleton Design Pattern**

| 🔧                     | Details                                                                       |
| ---------------------- | ----------------------------------------------------------------------------- |
| **Type**               | Creational Pattern                                                            |
| **Problem Solved**     | Ensure a class has **only one instance** and provides **global access** to it |
| **Real-World Analogy** | 🛂 Government: Only one **President/Prime Minister** exists at a time         |
| **Also Known As**      | Single Instance Pattern                                                       |

---

## 🎯 **Intent**

> Ensure a class has only **one instance** and provide a **global point of access** to it.

---

## 📦 **Core Idea**

* Make **constructor private**
* Provide a **static method** to get the instance
* Store instance in a **private static field**

---

# 📊 **UML Diagram**

```plaintext
+---------------------+
|     Singleton       |
+---------------------+
| - instance: Singleton (static) |
| - Singleton() (private)        |
| + getInstance(): Singleton     |
+---------------------+
```

---

## 💡 **Real-World Examples**

| Scenario                 | Singleton Usage                           |
| ------------------------ | ----------------------------------------- |
| Logger 📝                | One logger instance across app            |
| Configuration Manager ⚙️ | Load config only once                     |
| Thread Pool 🧵           | Single pool shared among components       |
| Cache 📦                 | Shared cache for performance              |
| DB Connection Pool 🔗    | Avoid opening multiple costly connections |

---

## 👨‍💻 Java Implementation (Lazy Initialization) ✅

```java
public class Singleton {
    private static Singleton instance;

    private Singleton() {
        System.out.println("✅ Singleton instance created");
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
```

### 🧪 Demo

```java
public class SingletonDemo {
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();

        System.out.println(s1 == s2); // true ✅
    }
}
```

---

## 🔐 Thread-Safe Version (Double-Checked Locking) 🔒

```java
public class ThreadSafeSingleton {
    private static volatile ThreadSafeSingleton instance;

    private ThreadSafeSingleton() {}

    public static ThreadSafeSingleton getInstance() {
        if (instance == null) {
            synchronized (ThreadSafeSingleton.class) {
                if (instance == null) {
                    instance = new ThreadSafeSingleton();
                }
            }
        }
        return instance;
    }
}
```

---

## 💎 Best Practice Version (Bill Pugh Singleton) 🔥

```java
public class BillPughSingleton {
    private BillPughSingleton() {}

    private static class SingletonHelper {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }
}
```

> ✅ No synchronization required  
> ✅ Thread-safe  
> ✅ Lazy-loaded    

---

## 📦 Enum-Based Singleton (Recommended by Joshua Bloch) 🛡️

```java
public enum EnumSingleton {
    INSTANCE;

    public void doSomething() {
        System.out.println("Doing work...");
    }
}
```

> ✅ Serialization safe  
> ✅ Reflection-proof  
> ✅ Best for simple singleton use-cases  

---

# ✅ When to Use Singleton Pattern

| Scenario                        | Benefit                          |
| ------------------------------- | -------------------------------- |
| Shared resource (Logger, Cache) | Prevent multiple object creation |
| Configuration/Settings manager  | Single access point              |
| Database connection pool        | Save memory and resources        |
| Centralized control over object | Coordination and consistency     |

---

# ⚠️ Common Pitfalls & Anti-Patterns

| Issue                        | How to Avoid                                      |
| ---------------------------- | ------------------------------------------------- |
| ❌ Global mutable state       | Keep it read-only or well-managed                 |
| ❌ Not thread-safe            | Use double-checked locking / inner static helper  |
| ❌ Reflection/Cloning attacks | Use Enum or override `clone()` & guard reflection |

---

# 🔥 System Design Examples

| System Component      | Singleton Role                                      |
| --------------------- | --------------------------------------------------- |
| `Logger`              | Unified logging across services                     |
| `ConfigLoader`        | One-time read from `application.yml`                |
| `ServiceRegistry`     | Register/discover microservices                     |
| `CacheManager`        | Global in-memory cache (like Redis)                 |
| `DBConnectionManager` | Manage database pooling & access                    |
| `AWS SDK Client`      | Share AWS clients like `S3Client`, `DynamoDBClient` |

---

# 🧠 Singleton vs Static Class

| Feature             | Singleton                        | Static Class             |
| ------------------- | -------------------------------- | ------------------------ |
| Instance-based?     | ✅ Yes                            | ❌ No                     |
| Inheritance?        | ✅ Yes (can implement interfaces) | ❌ No                     |
| Lazy Initialization | ✅ Yes                            | ❌ No                     |
| Testable/Mockable?  | ✅ Yes                            | ❌ No (difficult to mock) |
| Use Case            | Shared resource                  | Utility methods          |

---

# ✅ Pros & Cons

| ✅ Advantages                               | ❌ Disadvantages                     |
| ------------------------------------------ | ----------------------------------- |
| Single shared instance across app          | Hidden global state — hard to test  |
| Saves memory by avoiding repeated creation | Can introduce tight coupling        |
| Supports lazy initialization               | Complicates unit testing if misused |
| Easy to access globally                    | Not suitable for all use-cases      |

---

# 🚀 Interview Tips

✅ Explain **intent**: "Ensure only one instance"  
✅ Talk about **thread safety**  
✅ Show lazy-loading & **double-checked locking**  
✅ Mention **enum-based singleton** as best practice   
✅ Differentiate from **static class**  
✅ Add real-world use: config, logging, DB pool  

---

# 🏁 Summary

✅ Singleton = single instance shared globally  
✅ Best for config, logging, caching, registries  
✅ Use **Bill Pugh** or **Enum** for safe, clean design  
✅ Avoid **anti-patterns** by careful design  

---
