# 🧱 **Flyweight Design Pattern**

| 🔧                     | Details                                                                      |
| ---------------------- | ---------------------------------------------------------------------------- |
| **Type**               | Structural Pattern                                                           |
| **Problem Solved**     | Reduce memory usage by sharing objects with **common intrinsic state**       |
| **Real-World Analogy** | ♟️ Chess pieces reuse — all black pawns share shape, differ only in position |
| **Also Known As**      | Cache Pattern                                                                |

---

## 🎯 **Intent**

> Use sharing to support large numbers of fine-grained objects efficiently.
> Separate **intrinsic** (shared) from **extrinsic** (unique) state.

---

## 📦 **Core Idea**

* Store and reuse shared parts (intrinsic state)
* Avoid creating duplicate objects
* External state is passed in as context (extrinsic)

---

# 📊 **UML Diagram**

```plaintext
       +-------------------+
       |     Flyweight     |<-------------+
       +-------------------+              |
       | +operation(state) |              |
       +-------------------+              |
                ^                         |
        +-----------------+               |
        |ConcreteFlyweight|<--+           |
        +-----------------+   |           |
                              |           |
       +--------------------------+       |
       |     FlyweightFactory     |       |
       +--------------------------+-------+
       | - pool: Map<String, FW>  |
       | + getFlyweight(key): FW  |
       +--------------------------+
```

---

## 💡 **Real-World Analogy**

| Scenario               | Flyweight Role                                              |
| ---------------------- | ----------------------------------------------------------- |
| Chess game             | All white bishops share shape (intrinsic), position differs |
| Font glyphs            | Each 'a' shares rendering, position/size varies             |
| Trees in forest (game) | Reuse tree texture/model, change position/height            |

---

## 👨‍💻 Java Example: Forest Trees 🌳

---

### 1️⃣ Flyweight Interface

```java
interface TreeType {
    void display(int x, int y);
}
```

---

### 2️⃣ Concrete Flyweight

```java
class ConcreteTreeType implements TreeType {
    private String name;
    private String color;
    private String texture;

    public ConcreteTreeType(String name, String color, String texture) {
        this.name = name;
        this.color = color;
        this.texture = texture;
    }

    public void display(int x, int y) {
        System.out.println("🌳 Drawing tree at (" + x + ", " + y + ") of type " + name);
    }
}
```

---

### 3️⃣ Flyweight Factory

```java
import java.util.*;

class TreeFactory {
    private static Map<String, TreeType> treePool = new HashMap<>();

    public static TreeType getTreeType(String name, String color, String texture) {
        String key = name + color + texture;
        if (!treePool.containsKey(key)) {
            treePool.put(key, new ConcreteTreeType(name, color, texture));
        }
        return treePool.get(key);
    }
}
```

---

### 4️⃣ Context (Tree with extrinsic state)

```java
class Tree {
    private int x, y; // extrinsic
    private TreeType type; // intrinsic

    public Tree(int x, int y, TreeType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public void draw() {
        type.display(x, y);
    }
}
```

---

### 5️⃣ Demo

```java
public class FlyweightDemo {
    public static void main(String[] args) {
        TreeType oakType = TreeFactory.getTreeType("Oak", "Green", "Rough");
        TreeType pineType = TreeFactory.getTreeType("Pine", "Dark Green", "Smooth");

        Tree t1 = new Tree(10, 20, oakType);
        Tree t2 = new Tree(30, 40, oakType);
        Tree t3 = new Tree(50, 60, pineType);

        t1.draw();
        t2.draw();
        t3.draw();
    }
}
```

---

## 📦 Output

```
🌳 Drawing tree at (10, 20) of type Oak
🌳 Drawing tree at (30, 40) of type Oak
🌳 Drawing tree at (50, 60) of type Pine
```

---

# ✅ When to Use Flyweight Pattern

| Use Case                            | Benefit             |
| ----------------------------------- | ------------------- |
| Large number of similar objects     | Save memory         |
| Intrinsic data is repeatable/shared | Object reuse        |
| Object creation is costly           | Improve performance |

---

# 🚀 System Design Use Cases

| System       | Flyweight Usage                                 |
| ------------ | ----------------------------------------------- |
| Text Editor  | Font glyphs, cursor icons                       |
| Game Engine  | Trees, bullets, enemies (reuse models/textures) |
| UI Rendering | Reuse components (buttons, cards) across views  |
| Map Tiles    | Reuse tiles/images for maps                     |

---

# ✅ Pros & Cons

| ✅ Advantages                          | ❌ Disadvantages                     |
| ------------------------------------- | ----------------------------------- |
| Saves memory (object pooling)         | Makes code more complex             |
| Improves performance in heavy systems | Harder to debug with shared objects |
| Avoids object duplication             | Need to manage external state       |

---

# 🧠 Interview Tips

✅ Explain difference between **intrinsic** and **extrinsic** state<br>
✅ Talk about memory saving and object sharing<br>
✅ Mention real use cases in games or editors<br>
✅ Pair it with **Factory** pattern (used to cache objects)

---

# 🏁 Summary

✅ Flyweight = Share objects to save memory 🔁<br>
✅ Split shared vs varying data (intrinsic vs extrinsic)<br>
✅ Great for **games**, **text editors**, **rendering engines**<br>
✅ Combine with **Factory** to manage object caching

---
