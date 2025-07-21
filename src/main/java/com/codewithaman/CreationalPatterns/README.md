
# 🧠 **Creational Design Patterns — At a Glance**

| Pattern                 | Purpose                                | Real-World Analogy                            |
| ----------------------- | -------------------------------------- | --------------------------------------------- |
| **Singleton** 👑        | Ensure a class has only one instance   | Government: One PM/President per country      |
| **Factory Method** 🏭   | Delegate object creation to subclasses | Restaurant kitchen preparing different dishes |
| **Abstract Factory** 🏢 | Create related families of objects     | Furniture factory producing chairs + tables   |
| **Builder** 🧱          | Construct complex objects step-by-step | Assembling a custom burger or PC              |
| **Prototype** 🧬        | Clone existing object                  | Duplicating a document or template            |

---

# 🎯 **When Creational Patterns Are Used**

✅ You want to **control object creation**  
✅ You want to **decouple construction logic** from usage  
✅ You want to **reuse or cache** object creation  
✅ Object creation is **complex or conditional**  
✅ Creating multiple objects of a **family/type**  

---

# 🚀 **Most Asked in MAANG Interviews**

| Frequency | Pattern              |
| --------- | -------------------- |
| ⭐⭐⭐⭐⭐     | **Singleton**        |
| ⭐⭐⭐⭐      | **Factory Method**   |
| ⭐⭐⭐       | **Builder**          |
| ⭐⭐        | **Abstract Factory** |
| ⭐         | **Prototype**        |

---

# 📋 **Creational Patterns Summary Table**

| Pattern                | Quick Summary                                                          |
| ---------------------- | ---------------------------------------------------------------------- |
| **Singleton** 👑       | Ensure a class has only one instance (global access point)             |
| **Factory Method** 🏭  | Subclass decides which class to instantiate                            |
| **Abstract Factory**🏢 | Create families of related objects without specifying concrete classes |
| **Builder** 🧱         | Step-by-step creation of complex object                                |
| **Prototype** 🧬       | Clone or copy an existing object                                       |

---

# 🌍 **Real-World Analogy Breakdown**

| Pattern          | Analogy                                 | Example                               |
| ---------------- | --------------------------------------- | ------------------------------------- |
| Singleton        | One & only one President                | `Runtime.getRuntime()`, `Logger`      |
| Factory Method   | Restaurant chef chooses what to cook    | `DocumentBuilderFactory`, `Calendar`  |
| Abstract Factory | Kit factory (Chair + Sofa + Table sets) | `UIFactory` for Dark/Light theme      |
| Builder          | Build your own Burger 🍔/PC 💻          | `StringBuilder`, `Lombok @Builder`    |
| Prototype        | Copy existing resume/template           | `clone()` method, Prototypes in games |

---

# 💥 **Pros and Cons**

| Pattern              | ✅ Pros                                       | ❌ Cons                          |
| -------------------- | -------------------------------------------- | ------------------------------- |
| **Singleton**        | Controlled access, shared config             | Global state risk, hard to test |
| **Factory Method**   | Decouples creation logic, open for extension | More classes                    |
| **Abstract Factory** | Easy to switch product families              | Complex for small cases         |
| **Builder**          | Good for immutable or complex objects        | Verbose if object is simple     |
| **Prototype**        | Cloning avoids cost of new creation          | Deep clone may be tricky        |

---

# 💼 **Where You’ll Use Them**

| Pattern          | Used In                                       |
| ---------------- | --------------------------------------------- |
| Singleton        | Config managers, caches, loggers              |
| Factory Method   | Service locator, DAO factories, file parsers  |
| Abstract Factory | UI toolkits, game engines (platforms/skins)   |
| Builder          | DTOs, REST client request builders, test data |
| Prototype        | Game dev, GUI elements, resume generators     |

---

# 📊 **Cheat Sheet for Interviews**

| Pattern          | Use Case Example                             | Java API Example                         |
| ---------------- | -------------------------------------------- | ---------------------------------------- |
| Singleton        | Config, Logger, DB Connection Pool           | `Runtime`, `Desktop`, `Logger`           |
| Factory Method   | Create parser for JSON, XML, CSV             | `DocumentBuilderFactory`                 |
| Abstract Factory | GUI components for Mac/Windows/Linux         | `javax.swing.UIManager.getLookAndFeel()` |
| Builder          | Build complex `User` object with many fields | `StringBuilder`, `Calendar.Builder`      |
| Prototype        | Copy an existing `Shape` or `Document`       | `clone()`                                |

---

# ✅ **MAANG Interview Tips**

For each creational pattern, clearly explain:

1. 📊 **Intent**: Why this pattern exists
2. 🎯 **Use Case**: Where/why it's used
3. 🧩 **Class Roles**: Creator, Product, Director (for Builder)
4. ⚙️ **Java Implementation** (or usage in standard libs)
5. 💡 **Trade-offs**: Pros vs Cons
6. 💼 **When you used it in a project**

---
