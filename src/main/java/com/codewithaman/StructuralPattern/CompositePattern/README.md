# 🌳 **Composite Design Pattern**

| 🔧                     | Details                                                    |
| ---------------------- | ---------------------------------------------------------- |
| **Type**               | Structural Pattern                                         |
| **Problem Solved**     | Treat individual objects and compositions uniformly        |
| **Real-World Analogy** | 🗂️ Folder structure (Folder can have files or subfolders) |
| **Also Known As**      | Part-Whole Pattern                                         |

---

## 🎯 **Intent**

> Compose objects into **tree structures** to represent part-whole hierarchies.
> Treat **individual objects and groups** of objects uniformly.

---

## 📦 **Core Idea**

* Use a **common interface** for leaf and composite nodes
* Composite holds **children** (can be leaf or composite)
* Clients treat all nodes through the **same interface**

---

# 📊 **UML Diagram**

```plaintext
     +--------------+
     |   Component  |
     +--------------+
     | + operation()|
     +--------------+
           ^
     ______|_______
    |              |
+------------+  +--------------------------------+
|   Leaf     |  |  Composite                     |
+------------+  +--------------------------------+
| operation()|  | - children                     |
+------------+  | + add(), remove(), operation() |
                +--------------------------------+
```

---

## 💡 **Real-World Analogy**

| Scenario           | Composite Role                                |
| ------------------ | --------------------------------------------- |
| File system        | Folders can contain files or other folders    |
| Organization chart | Manager has employees or sub-managers         |
| GUI components     | Panel contains buttons, labels, or sub-panels |

---

## 👨‍💻 Java Example: Graphic Objects (Shapes)

---

### 1️⃣ Component Interface

```java
public interface Graphic {
    void draw();
}
```

---

### 2️⃣ Leaf Classes

```java
public class Circle implements Graphic {
    public void draw() {
        System.out.println("Drawing Circle");
    }
}

public class Square implements Graphic {
    public void draw() {
        System.out.println("Drawing Square");
    }
}
```

---

### 3️⃣ Composite Class

```java
import java.util.*;

public class CompositeGraphic implements Graphic {
    private List<Graphic> children = new ArrayList<>();

    public void add(Graphic g) {
        children.add(g);
    }

    public void remove(Graphic g) {
        children.remove(g);
    }

    public void draw() {
        for (Graphic g : children) {
            g.draw();
        }
    }
}
```

---

### 🧪 Demo

```java
public class CompositeDemo {
    public static void main(String[] args) {
        Graphic circle = new Circle();
        Graphic square = new Square();

        CompositeGraphic drawing = new CompositeGraphic();
        drawing.add(circle);
        drawing.add(square);

        CompositeGraphic subDrawing = new CompositeGraphic();
        subDrawing.add(new Circle());
        subDrawing.add(new Square());

        drawing.add(subDrawing);

        drawing.draw();
    }
}
```

---

# ✅ When to Use Composite Pattern

| Situation                        | Composite Benefit                         |
| -------------------------------- | ----------------------------------------- |
| Part-whole hierarchies           | Easily model tree-like structure          |
| Uniform treatment of nodes       | Use common interface for all elements     |
| Complex UI or graphic structures | Nest components (buttons, panels, groups) |

---

# 🚀 System Design Use Cases

| System Component      | Composite Utility                                |
| --------------------- | ------------------------------------------------ |
| File system structure | Directories and files under same interface       |
| GUI frameworks        | Panels, buttons, text fields uniformly rendered  |
| Scene graphs (games)  | Game objects grouped into composite render units |
| Menu system           | Nested menus and options                         |

---

# ⚖️ Composite vs Decorator vs Strategy

| Pattern   | Purpose                     | Key Mechanism         |
| --------- | --------------------------- | --------------------- |
| Composite | Part-whole tree structure   | Hierarchy & recursion |
| Decorator | Add behavior dynamically    | Wrapping/composition  |
| Strategy  | Switch algorithm at runtime | Delegation            |

---

# ✅ Pros & Cons

| ✅ Advantages                    | ❌ Disadvantages                       |
| ------------------------------- | ------------------------------------- |
| Simplifies client code          | Can make design too general           |
| Tree structure is easy to scale | Might be overkill for flat structures |
| Promotes consistent behavior    | Harder to restrict Composite contents |

---

# 🧠 Interview Tips

✅ Explain intent: Tree structure with uniform treatment<br>
✅ Use file system or GUI as a real-world analogy<br>
✅ Show interface-based design with leaf and composite<br>
✅ Highlight recursive behavior in `operation()` calls<br>
✅ Differentiate clearly from Decorator & Strategy

---

# 🏁 Summary

✅ Composite = Tree structure where nodes can be leaf or group  
✅ Common in UI, file systems, scene graphs, org charts  
✅ Simplifies clients by treating all nodes uniformly  
✅ Promotes scalability, flexibility, and code reuse  

---
