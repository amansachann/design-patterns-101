# 🧠 **Factory Method Design Pattern**

| 🔧                     | Details                                                        |
| ---------------------- | -------------------------------------------------------------- |
| **Type**               | Creational Pattern                                             |
| **Problem Solved**     | Delegate object **creation logic** to **subclasses/factories** |
| **Real-World Analogy** | 🍽️ Restaurant: Waiter takes order, chef prepares dish         |
| **Also Known As**      | Virtual Constructor Pattern                                    |

---

## 🎯 **Intent**

> Define an interface for creating an object, but let **subclasses decide** which class to instantiate.

---

## 📦 **Core Idea**

* Create objects **without exposing instantiation logic**
* Use a **common interface** to create product variants
* Enables loose coupling between **creator** and **product**

---

# 📊 **UML Diagram**

```plaintext
+--------------------+           +--------------------+
|    Creator         |◄──────────|  ConcreteCreator    |
+--------------------+           +--------------------+
| + factoryMethod()  |           | + factoryMethod()  |
| + someOperation()  |           +--------------------+
+--------------------+
         |
         v
+-------------------+
|   Product         | (interface)
+-------------------+
| + operation()     |
+-------------------+
         ▲
         |
+------------------------+
|   ConcreteProduct      |
+------------------------+
```

---

## 💡 **Real-World Analogy: Document Generator 📝**

Imagine an **OfficeSuite** that generates different document types:

* Word Doc (.docx)
* PDF File (.pdf)
* Spreadsheet (.xlsx)

✅ Factory Method allows different apps (Word, Excel) to implement their own document creation logic!

---

## 👨‍💻 Java Implementation Example

---

### 1️⃣ **Product Interface**

```java
public interface Document {
    void open();
}
```

---

### 2️⃣ **Concrete Products**

```java
public class WordDocument implements Document {
    public void open() {
        System.out.println("📝 Opening Word document...");
    }
}
```

```java
public class PdfDocument implements Document {
    public void open() {
        System.out.println("📄 Opening PDF document...");
    }
}
```

---

### 3️⃣ **Creator (Abstract)**

```java
public abstract class DocumentFactory {
    public abstract Document createDocument();

    public void openDocument() {
        Document doc = createDocument();
        doc.open();
    }
}
```

---

### 4️⃣ **Concrete Creators**

```java
public class WordDocumentFactory extends DocumentFactory {
    public Document createDocument() {
        return new WordDocument();
    }
}
```

```java
public class PdfDocumentFactory extends DocumentFactory {
    public Document createDocument() {
        return new PdfDocument();
    }
}
```

---

### 5️⃣ **Client**

```java
public class FactoryPatternDemo {
    public static void main(String[] args) {
        DocumentFactory factory1 = new WordDocumentFactory();
        factory1.openDocument(); // Word

        DocumentFactory factory2 = new PdfDocumentFactory();
        factory2.openDocument(); // PDF
    }
}
```

---

## 📊 Output

```
📝 Opening Word document...
📄 Opening PDF document...
```

---

# ✅ When to Use Factory Pattern

| Scenario                                    | Benefit                            |
| ------------------------------------------- | ---------------------------------- |
| Need to **decouple instantiation** from use | Promotes loose coupling            |
| Want to **abstract away product variants**  | New types can be introduced easily |
| Object creation needs to be **dynamic**     | Useful for plugins/extensions      |

---

# ✅ Real-World Use Cases

| System          | Factory Usage                                 |
| --------------- | --------------------------------------------- |
| GUI Toolkit     | Create buttons, sliders for different OS      |
| Game Engine     | Spawn different characters/objects            |
| Logging System  | Different logger types (file, console)        |
| Payment Gateway | Create `Razorpay`, `PayPal`, `Stripe` clients |
| Document Parser | Based on file type, return parser object      |

---

## 🧰 Factory Pattern in Java Standard Library

| Java API                   | Usage Example                    |
| -------------------------- | -------------------------------- |
| `DocumentBuilderFactory`   | XML document parsing             |
| `Calendar.getInstance()`   | Returns specific calendar object |
| `Logger.getLogger()`       | Factory method for loggers       |
| `ConnectionFactory` (JDBC) | For database connections         |
| `java.util.ServiceLoader`  | Plugin-based factory loading     |

---

# 💎 Factory Pattern vs Others

| Pattern              | Purpose                                 |
| -------------------- | --------------------------------------- |
| **Factory Method**   | Subclass decides which object to create |
| **Abstract Factory** | Create families of related objects      |
| **Builder**          | Step-by-step object construction        |
| **Prototype**        | Clone existing object                   |
| **Singleton**        | Only one instance                       |

---

# ✅ Pros and Cons

| ✅ Advantages                   | ❌ Disadvantages                       |
| ------------------------------ | ------------------------------------- |
| Isolates object creation logic | Can add complexity with many classes  |
| Promotes Open/Closed Principle | Sometimes overkill for simple objects |
| Easier to introduce new types  | Difficult to trace code flow at times |
| Improves testing and mocking   |                                       |

---

# 🔥 System Design Use Cases

| Component           | Factory Pattern Role             |
| ------------------- | -------------------------------- |
| Parser Factory      | JSON, XML, CSV parsing           |
| Notification Sender | Email, SMS, Push implementations |
| Report Generator    | PDF, Excel, CSV formats          |
| Payment Processor   | Razorpay, Stripe, PayPal handler |
| Event Dispatcher    | Event type to handler map        |
| Image Decoder       | JPEG, PNG, SVG factories         |

---

# 🚀 MAANG Interview Tips

✅ Start by explaining:

* **Intent**: Decouple object creation
* **Participants**: Product, Creator, ConcreteCreator
* **Benefit**: Add new types without changing existing code  
  ✅ Mention `DocumentBuilderFactory`, `Calendar.getInstance()` from Java  
  ✅ Demonstrate **Open/Closed Principle**  

---

# 🏁 Summary

✅ Factory Method = **Delegate creation to subclasses**  
✅ Use when object creation is **dynamic or type-specific**  
✅ Improves **flexibility**, **testability**, and **maintainability**  
✅ Avoids tight coupling between **caller and object instantiation**  

---
