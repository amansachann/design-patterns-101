# 🎨 **Decorator Design Pattern**

| 🔧                     | Details                                                                  |
| ---------------------- | ------------------------------------------------------------------------ |
| **Type**               | Structural Pattern                                                       |
| **Problem Solved**     | Add new **responsibilities/behavior** to objects **dynamically**         |
| **Real-World Analogy** | 📦 Gift wrapping (wrapping an object to enhance its appearance/behavior) |
| **Also Known As**      | Wrapper Pattern                                                          |

---

## 🎯 **Intent**

> Attach additional responsibilities to an object dynamically.
> Decorators provide a flexible alternative to subclassing for extending functionality.

---

## 📦 **Core Idea**

* Compose objects instead of subclassing
* Decorators **wrap original objects** and **add extra functionality**
* Can be chained together

---

# 📊 **UML Diagram**

```plaintext
+-------------+
|  Component  |<----------------------+
+-------------+                       |
| + operation()|                     |
+-------------+                       |
        ^                             |
        |                             |
+---------------+           +-------------------+
|  ConcreteComponent |       |   Decorator       |
+-------------------+       +-------------------+
                          | - component: Component |
                          | + operation()          |
                          +-------------------+
                                      ^
                                      |
                      +------------------------------+
                      |   ConcreteDecorator           |
                      +------------------------------+
```

---

## 💡 **Real-World Analogy**

| Scenario             | Decorator Role                                    |
| -------------------- | ------------------------------------------------- |
| Coffee customization | Add milk, sugar, or caramel without changing base |
| Christmas gift wrap  | Wrap box with paper, ribbon, tag                  |
| UI scrollbars        | Add scrolling to window components dynamically    |

---

## 👨‍💻 Java Example: Coffee Shop ☕

---

### 1️⃣ Component Interface

```java
public interface Coffee {
    String getDescription();
    double getCost();
}
```

---

### 2️⃣ Concrete Component

```java
public class BasicCoffee implements Coffee {
    public String getDescription() {
        return "Basic Coffee";
    }
    public double getCost() {
        return 5.0;
    }
}
```

---

### 3️⃣ Abstract Decorator

```java
public abstract class CoffeeDecorator implements Coffee {
    protected Coffee coffee;

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    public String getDescription() {
        return coffee.getDescription();
    }

    public double getCost() {
        return coffee.getCost();
    }
}
```

---

### 4️⃣ Concrete Decorators

```java
public class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    public String getDescription() {
        return coffee.getDescription() + ", Milk";
    }

    public double getCost() {
        return coffee.getCost() + 1.5;
    }
}
```

```java
public class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    public String getDescription() {
        return coffee.getDescription() + ", Sugar";
    }

    public double getCost() {
        return coffee.getCost() + 0.5;
    }
}
```

---

### 🧪 Demo

```java
public class DecoratorDemo {
    public static void main(String[] args) {
        Coffee coffee = new BasicCoffee();
        coffee = new MilkDecorator(coffee);
        coffee = new SugarDecorator(coffee);

        System.out.println(coffee.getDescription()); // Basic Coffee, Milk, Sugar
        System.out.println("Cost: $" + coffee.getCost()); // 7.0
    }
}
```

---

# ✅ When to Use Decorator Pattern

| Situation                                 | Why Decorator Helps           |
| ----------------------------------------- | ----------------------------- |
| Add features to objects at runtime        | Avoids subclass explosion     |
| Want flexible alternatives to inheritance | Compose behavior dynamically  |
| UI components, stream handling, logging   | Common real-world application |

---

# 🚀 System Design Use Cases

| System Component    | Decorator Utility                                  |
| ------------------- | -------------------------------------------------- |
| Java I/O Streams    | InputStream → Buffered → Gzip                      |
| Web Request Filters | Add logging, auth, rate-limit wrappers             |
| UI Elements         | Add borders, scrollbars, shadows to base component |
| Logger Systems      | Add timestamp, levels, filters dynamically         |

---

# ⚔️ Decorator vs Inheritance vs Adapter

| Pattern     | Goal                             | Strategy               |
| ----------- | -------------------------------- | ---------------------- |
| Decorator   | Add responsibilities dynamically | Composition            |
| Inheritance | Extend behavior statically       | Subclassing            |
| Adapter     | Match incompatible interfaces    | Wrapping + translation |

---

# ✅ Pros & Cons

| ✅ Advantages                          | ❌ Disadvantages                     |
| ------------------------------------- | ----------------------------------- |
| Flexible runtime behavior composition | Many small classes                  |
| Follows Open/Closed Principle         | Debugging and tracing may be harder |
| Avoids subclass explosion             | Increased complexity when overused  |

---

# 🧠 Interview Tips

✅ Mention dynamic composition over static inheritance<br>
✅ Java I/O is a famous example (InputStream hierarchy)<br>
✅ Emphasize Open/Closed principle compliance<br>
✅ Clarify difference between Decorator & Adapter<br>
✅ Show real-world analogy like Coffee with Add-ons ☕

---

# 🏁 Summary

✅ Decorator = dynamic behavior addition without subclassing  
✅ Used in I/O, UI, logging, web filters  
✅ Promotes flexibility, modularity, and extensibility  
✅ Avoids rigid inheritance hierarchies  
