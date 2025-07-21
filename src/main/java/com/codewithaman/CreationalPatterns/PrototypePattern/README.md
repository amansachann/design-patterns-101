# 🧠 **Prototype Design Pattern**

| 🔧                     | Details                                                          |
| ---------------------- | ---------------------------------------------------------------- |
| **Type**               | Creational Pattern                                               |
| **Problem Solved**     | Avoid the cost of creating objects from scratch                  |
| **Real-World Analogy** | 📝 Copying a **Resume Template** or duplicating a game character |
| **Also Known As**      | Clone Pattern                                                    |

---

## 🎯 **Intent**

> Create new objects by **copying an existing object**, known as a **prototype**, instead of building from scratch.

---

## 📦 **Core Idea**

* Define a **clone()** operation in objects
* Duplicate objects with same structure/state
* Use when object creation is **costly or complex**

---

# 📊 **UML Diagram**

```plaintext
+-------------------+
|   Prototype       | (interface)
+-------------------+
| + clone()         |
+-------------------+
         ▲
         |
+-------------------+         +------------------+
| ConcretePrototype1|<--------| Client           |
+-------------------+         +------------------+
| + clone()         |         | - prototype      |
+-------------------+         | + makeCopy()     |
```

---

## 💡 **Real-World Analogy: Resume Builder**

> You create a **master resume**, and then copy it to apply to different companies — just updating company name or skills.

✅ Prototype pattern lets you create copies without reinitializing everything from scratch.

---

## 👨‍💻 Java Example: Game Characters 🎮

---

### 1️⃣ **Prototype Interface**

```java
public interface GameCharacter extends Cloneable {
    GameCharacter clone();
    void display();
}
```

---

### 2️⃣ **Concrete Prototypes**

```java
public class Warrior implements GameCharacter {
    private String weapon;
    private int strength;

    public Warrior(String weapon, int strength) {
        this.weapon = weapon;
        this.strength = strength;
    }

    public GameCharacter clone() {
        return new Warrior(this.weapon, this.strength);
    }

    public void display() {
        System.out.println("🗡️ Warrior with " + weapon + ", Strength: " + strength);
    }
}
```

```java
public class Mage implements GameCharacter {
    private String spell;
    private int mana;

    public Mage(String spell, int mana) {
        this.spell = spell;
        this.mana = mana;
    }

    public GameCharacter clone() {
        return new Mage(this.spell, this.mana);
    }

    public void display() {
        System.out.println("🧙 Mage with spell: " + spell + ", Mana: " + mana);
    }
}
```

---

### 3️⃣ **Client Code**

```java
public class PrototypeDemo {
    public static void main(String[] args) {
        GameCharacter warrior1 = new Warrior("Sword", 80);
        GameCharacter warrior2 = warrior1.clone();

        GameCharacter mage1 = new Mage("Fireball", 100);
        GameCharacter mage2 = mage1.clone();

        warrior1.display();
        warrior2.display();
        mage1.display();
        mage2.display();
    }
}
```

---

## 📊 Output

```
🗡️ Warrior with Sword, Strength: 80
🗡️ Warrior with Sword, Strength: 80
🧙 Mage with spell: Fireball, Mana: 100
🧙 Mage with spell: Fireball, Mana: 100
```

---

# ✅ When to Use Prototype Pattern

| Scenario                                      | Why It Helps                                |
| --------------------------------------------- | ------------------------------------------- |
| Object creation is **expensive** or **slow**  | Avoids cost of full construction            |
| Many objects share same structure             | Easy to duplicate base template             |
| Need **runtime object configuration**         | Clone pre-configured prototypes             |
| Need to add new classes without changing code | New types register themselves as prototypes |

---

## 🔥 Real-World Use Cases

| System           | Prototype Pattern Usage             |
| ---------------- | ----------------------------------- |
| Game Engines     | Cloning characters, weapons, skills |
| Document Editors | Copy templates, documents, charts   |
| Graphic Editors  | Duplicate shapes, text boxes        |
| Workflow Engines | Cloning tasks/jobs                  |
| AI/ML Pipelines  | Copying pipeline templates/configs  |

---

## ✅ Java API Example

| Java Class               | Pattern Used                       |
| ------------------------ | ---------------------------------- |
| `java.lang.Object`       | `clone()` method                   |
| `ArrayList.clone()`      | Creates shallow copy               |
| `HashMap.clone()`        | Clones key-value pairs             |
| `PrototypeBean` (Spring) | Configurable prototype scope beans |

---

# ✅ Pros and Cons

| ✅ Advantages                          | ❌ Disadvantages                               |
| ------------------------------------- | --------------------------------------------- |
| Avoids expensive object creation      | Needs careful handling of deep/shallow copies |
| Easily duplicate complex structures   | `clone()` can be confusing/inconsistent       |
| Supports runtime object configuration | Can violate encapsulation                     |
| Reduces class hierarchy size          | Not ideal for immutable objects               |

---

# 🔥 System Design Examples

| Domain           | Use Case                               |
| ---------------- | -------------------------------------- |
| CMS              | Clone post/page templates              |
| UI Builders      | Duplicate components/forms             |
| Payment Gateways | Copy transaction config across systems |
| ML Platforms     | Clone pipeline configs/datasets        |
| CI/CD            | Duplicate pipelines/workflows          |

---

# 🚀 MAANG Interview Tips

✅ Mention:

* Prototype = clone existing objects
* Avoids rebuilding from scratch
* Good for **games**, **document systems**, **UI tools**

✅ Show how it works with Java’s `clone()`  
✅ Talk about **deep vs shallow copy**  
✅ Mention when cloning may be risky (mutable objects, resources, etc.)  

---

# 🧠 Deep vs Shallow Copy

| Copy Type        | Description                                | Java Example                        |
| ---------------- | ------------------------------------------ | ----------------------------------- |
| **Shallow Copy** | Copies references (not nested objects)     | `super.clone()` in `Object`         |
| **Deep Copy**    | Copies all nested objects (recursive copy) | Manual serialization or custom code |

---

# 🔁 Prototype vs Builder vs Factory

| Pattern       | Focus                           | Mechanism         |
| ------------- | ------------------------------- | ----------------- |
| **Prototype** | Clone existing instance         | `clone()` method  |
| **Builder**   | Step-by-step object creation    | `build()` method  |
| **Factory**   | Create new object based on type | `create()` method |

---

# 🏁 Summary

✅ Prototype = **create objects by cloning existing ones**  
✅ Use when object creation is **expensive, complex, or frequent**  
✅ Helps in **performance optimization, template systems, game dev**  
✅ Can be **deep** or **shallow** copy depending on requirements  
✅ Frequently seen in **game engines**, **editors**, **workflow tools**  

