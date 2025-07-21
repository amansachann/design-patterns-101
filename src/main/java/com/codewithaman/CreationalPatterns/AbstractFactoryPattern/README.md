# 🧠 **Abstract Factory Design Pattern**

| 🔧                     | Details                                                                    |
| ---------------------- | -------------------------------------------------------------------------- |
| **Type**               | Creational Pattern                                                         |
| **Problem Solved**     | Create **families of related objects** without specifying concrete classes |
| **Real-World Analogy** | 🪑 **Furniture Factory** that makes a matching chair, sofa, and table set  |
| **Also Known As**      | Kit Factory, Factory of Factories                                          |

---

## 🎯 **Intent**

> Provide an interface to create **families of related or dependent objects** without specifying their concrete classes.

---

## 📦 **Core Idea**

* Use when you need to create **related objects**
* Each family follows the same interface
* Keeps your client **decoupled** from object creation logic

---

# 📊 **UML Diagram**

```plaintext
+------------------------+           +-----------------------------+
|  AbstractFactory       |<----------|  ConcreteFactoryA           |
+------------------------+           +-----------------------------+
| + createProductA()     |           | + createProductA()          |
| + createProductB()     |           | + createProductB()          |
+------------------------+           +-----------------------------+
         |                                          |
         v                                          v
+---------------------+                   +----------------------+
| AbstractProductA     |                 | AbstractProductB      |
+---------------------+                   +----------------------+
         ^                                          ^
         |                                          |
+---------------------+                   +----------------------+
| ConcreteProductA1    |                 | ConcreteProductB1     |
+---------------------+                   +----------------------+
```

---

## 💡 **Real-World Analogy: Furniture Shop 🪑**

Imagine a shop that sells **Modern** and **Victorian** furniture sets.

Each set has:

* Chair
* Sofa
* Coffee Table

✅ Abstract Factory lets you switch entire furniture themes without breaking your client logic!

---

## 👨‍💻 Java Implementation: UI Theme Factory 🌙🪟

---

### 1️⃣ **Abstract Products**

```java
interface Button {
    void render();
}

interface Checkbox {
    void render();
}
```

---

### 2️⃣ **Concrete Products**

```java
class DarkButton implements Button {
    public void render() {
        System.out.println("🖤 Rendering Dark Button");
    }
}

class LightButton implements Button {
    public void render() {
        System.out.println("🤍 Rendering Light Button");
    }
}

class DarkCheckbox implements Checkbox {
    public void render() {
        System.out.println("🖤 Rendering Dark Checkbox");
    }
}

class LightCheckbox implements Checkbox {
    public void render() {
        System.out.println("🤍 Rendering Light Checkbox");
    }
}
```

---

### 3️⃣ **Abstract Factory**

```java
interface UIComponentFactory {
    Button createButton();
    Checkbox createCheckbox();
}
```

---

### 4️⃣ **Concrete Factories**

```java
class DarkThemeFactory implements UIComponentFactory {
    public Button createButton() {
        return new DarkButton();
    }
    public Checkbox createCheckbox() {
        return new DarkCheckbox();
    }
}

class LightThemeFactory implements UIComponentFactory {
    public Button createButton() {
        return new LightButton();
    }
    public Checkbox createCheckbox() {
        return new LightCheckbox();
    }
}
```

---

### 5️⃣ **Client Code**

```java
class Application {
    private Button button;
    private Checkbox checkbox;

    public Application(UIComponentFactory factory) {
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }

    public void renderUI() {
        button.render();
        checkbox.render();
    }
}
```

---

### 6️⃣ **Demo**

```java
public class AbstractFactoryDemo {
    public static void main(String[] args) {
        UIComponentFactory darkFactory = new DarkThemeFactory();
        Application darkApp = new Application(darkFactory);
        darkApp.renderUI();

        UIComponentFactory lightFactory = new LightThemeFactory();
        Application lightApp = new Application(lightFactory);
        lightApp.renderUI();
    }
}
```

---

## 📊 Output

```
🖤 Rendering Dark Button
🖤 Rendering Dark Checkbox
🤍 Rendering Light Button
🤍 Rendering Light Checkbox
```

---

# ✅ When to Use Abstract Factory Pattern

| Scenario                                        | Why Abstract Factory Helps               |
| ----------------------------------------------- | ---------------------------------------- |
| UI Themes (Dark, Light, Material)               | Produce consistent component families    |
| Cross-platform software (Windows, macOS, Linux) | Create OS-specific objects               |
| Families of related objects                     | Enforce compatibility between components |
| Plugin or strategy selection                    | Switch entire product variants           |

---

# ✅ Real-World Use Cases

| System              | Factory Usage Example                        |
| ------------------- | -------------------------------------------- |
| GUI Frameworks      | Button, Checkbox, Dropdown per theme         |
| Database Connectors | MySQLFactory, PostgresFactory, OracleFactory |
| Cloud Providers     | AWSFactory, AzureFactory, GCPFactory         |
| Game Engines        | AlienFactory, ZombieFactory                  |
| E-Commerce Checkout | Payment UI/Flow for regions (EU/US/Asia)     |

---

## 💎 Abstract Factory in Java APIs

| Java API                  | Pattern Used                        |
| ------------------------- | ----------------------------------- |
| `javax.xml.parsers`       | DOM vs SAX parsers                  |
| `javax.sql.DataSource`    | Create JDBC connections per DB      |
| `javax.net.SocketFactory` | SSL/Plain socket creation factories |

---

# ✅ Pros and Cons

| ✅ Advantages                                | ❌ Disadvantages                           |
| ------------------------------------------- | ----------------------------------------- |
| Groups related products under a single unit | Complex if too many factories/products    |
| Easily **swap product families**            | Requires many classes                     |
| Promotes **Open/Closed Principle**          | Tight coupling between factory and client |
| Ensures **compatibility** across components |                                           |

---

# 🧠 Factory vs Abstract Factory

| Feature             | **Factory Method** | **Abstract Factory**                  |
| ------------------- | ------------------ | ------------------------------------- |
| Produces            | Single product     | Family of related products            |
| Example             | `createButton()`   | `createButton()` + `createCheckbox()` |
| Return Type         | One interface      | Multiple interfaces                   |
| Extendable Families | ❌ No               | ✅ Yes                                 |
| Real-World Use      | Document creator   | Theme-based UI factory                |

---

# 🔥 System Design Use Cases

| System Component          | Abstract Factory Role                          |
| ------------------------- | ---------------------------------------------- |
| GUI Toolkit               | OS/Theme-specific UI components                |
| Cloud Service Provisioner | AWS/Azure/GCP-specific service classes         |
| Notification Engine       | SMS, Email, Push creation factories            |
| Microservices Gateway     | Create request handlers per region/client type |
| E-Commerce Platform       | Create checkout/payments per market or brand   |

---

# 🚀 Interview Tips

✅ Start by defining the **intent**: produce families of related objects  
✅ Draw UML and explain participants: `AbstractFactory`, `ConcreteFactory`, `Product`  
✅ Show how it **decouples object creation** from usage  
✅ Mention **GUI Theme switch**, **DB driver families**, **plugin engines**  
✅ Compare with **Factory Method** and **Builder**  

---

# 🏁 Summary

✅ Abstract Factory = **factory of factories**  
✅ Ideal for creating **families of related products**  
✅ Promotes **modularity, testability, flexibility**  
✅ Heavy usage in **UI systems, OS drivers, cloud SDKs, plugin loaders**  
✅ Frequently asked in MAANG **LLD/System Design** rounds  

---

