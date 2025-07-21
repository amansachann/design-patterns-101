# 🧠 **Structural Design Patterns — At a Glance**

| Pattern          | Purpose                                     | Real-World Analogy                       |
| ---------------- | ------------------------------------------- | ---------------------------------------- |
| **Adapter** ♾    | Connect incompatible interfaces             | Power adapter (EU plug to US socket)     |
| **Bridge** 🌉    | Separate abstraction from implementation    | TV Remote controlling multiple TV brands |
| **Composite** 🧩 | Tree structure for part-whole hierarchies   | Folder with files and subfolders         |
| **Decorator** 🎭 | Add behavior dynamically                    | Pizza with toppings                      |
| **Facade** 🏠    | Simplified interface to complex system      | Hotel receptionist                       |
| **Flyweight** 🪖 | Share common parts to save memory           | Characters in a text editor              |
| **Proxy** 🧱     | Surrogate controlling access to real object | Credit card as proxy for bank account    |

---

# 🌟 **Most Common in MAANG Interviews**

| Frequency | Pattern                               |
| --------- | ------------------------------------- |
| ⭐⭐⭐⭐⭐     | **Adapter**                           |
| ⭐⭐⭐⭐      | **Decorator**                         |
| ⭐⭐⭐       | **Proxy**                             |
| ⭐⭐        | **Composite**                         |
| ⭐         | **Facade**, **Bridge**, **Flyweight** |

---

# 📄 **Structural Patterns Summary Table**

| Pattern       | Quick Summary                                                  |
| ------------- | -------------------------------------------------------------- |
| **Adapter**   | Make incompatible interfaces work together                     |
| **Bridge**    | Decouple abstraction and implementation                        |
| **Composite** | Tree structure: treat objects uniformly                        |
| **Decorator** | Attach new behavior to object dynamically                      |
| **Facade**    | Provide unified interface to complex subsystems                |
| **Flyweight** | Share common data between many objects to save memory          |
| **Proxy**     | Control access to another object (remote, virtual, protective) |

---

# 🌎 **Real-World Analogy Breakdown**

| Pattern   | Analogy                                | Example                            |
| --------- | -------------------------------------- | ---------------------------------- |
| Adapter   | Plug converter                         | `InputStreamReader`                |
| Bridge    | Remote control + different TVs         | `JDBC` driver abstraction          |
| Composite | Folder with files + folders            | `javax.swing.JComponent`           |
| Decorator | Coffee + milk + caramel toppings       | `BufferedReader` wrapping `Reader` |
| Facade    | Hotel receptionist simplifies requests | `java.util.logging.Logger`         |
| Flyweight | Share letters in word processor        | `Integer.valueOf()` cache          |
| Proxy     | Credit card for payment                | `java.lang.reflect.Proxy`          |

---

# 📊 **Pros and Cons**

| Pattern   | ✅ Pros                                | ❌ Cons                               |
| --------- | ------------------------------------- | ------------------------------------ |
| Adapter   | Reusability, works with legacy code   | Extra code layer adds indirection    |
| Bridge    | Separate concerns, open for extension | More classes to manage               |
| Composite | Uniformity simplifies client logic    | Harder to restrict tree structure    |
| Decorator | No subclass explosion, flexible       | Can become complex with many layers  |
| Facade    | Easy to use interface                 | Can hide important internal behavior |
| Flyweight | Memory efficient                      | Complexity in managing shared state  |
| Proxy     | Add security, logging, lazy loading   | Introduces latency/overhead          |

---

# 🎓 **Where You'll Use Them**

| Pattern   | Used In                                     |
| --------- | ------------------------------------------- |
| Adapter   | APIs, Payment Integrations                  |
| Bridge    | UI libraries, Drivers, Remote APIs          |
| Composite | File explorers, UI components               |
| Decorator | Streams, Logging, UI widgets                |
| Facade    | Libraries, SDKs, Complex frameworks         |
| Flyweight | Game dev, Text rendering                    |
| Proxy     | Caching, Lazy loading, Authorization layers |

---

# 📈 **Cheat Sheet for Interviews**

| Pattern   | Use Case Example                       | Java API Example                                        |
| --------- | -------------------------------------- | ------------------------------------------------------- |
| Adapter   | Make `CSVParser` work with `XMLReader` | `InputStreamReader`, `Arrays.asList()`                  |
| Bridge    | Separate Shape & Color in drawing tool | `JDBC` driver switching                                 |
| Composite | Tree Menu in UI                        | `Component` in AWT/Swing                                |
| Decorator | Logging wrapper                        | `BufferedInputStream`, `Collections.unmodifiableList()` |
| Facade    | One class calls multiple subsystems    | `javax.faces.context.FacesContext`                      |
| Flyweight | Shared game objects (trees, particles) | `Integer.valueOf()` caching                             |
| Proxy     | Access control / remote object         | `java.lang.reflect.Proxy`                               |

---

# ✅ **MAANG Interview Tips**

For each structural pattern, clearly explain:

1. 📊 **Intent** — Why it's needed
2. 🔎 **Use Case** — Real-world relevance
3. 🌍 **Analogy** — Make it relatable
4. 🔧 **Class Roles** — Who plays what part
5. 📘 **Java API Usage** — If any
6. 📆 **Trade-offs** — Pros vs Cons
7. 🚀 **Where YOU used it** or system design example
