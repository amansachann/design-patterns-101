# **Memento Pattern 🧳**

👉 **Definition**:
The **Memento Pattern** is used to capture and restore the state of an object without exposing its internal structure.

Think of it like:
🕰️ *"Take a snapshot of an object, so you can go back to that snapshot later."*

---

# **Real-world Example 🎯**

Imagine you are writing a text document in an editor:

* You write some text ➡️ Save (create a memento).
* You write more ➡️ Save again.
* You make a mistake ➡️ Restore from the previous save.

---

# **Participants 👥**

| Role           | Description                                                   |
| -------------- | ------------------------------------------------------------- |
| **Originator** | The object whose state you want to save and restore.          |
| **Memento**    | The snapshot of the Originator’s state.                       |
| **Caretaker**  | Keeps track of the Mementos and decides when to save/restore. |

---

# **UML Diagram 📊**

```plaintext
+----------------+       +--------------+       +-------------------+
|  Caretaker     |<>---->|   Memento    |<----->|  Originator       |
+----------------+       +--------------+       +-------------------+
| - mementos[]   |       | + state      |       | - state           |
| + save()       |       +--------------+       | + createMemento() |
| + undo()       |                              | + restoreMemento()|
+----------------+                               +------------------+
```

---

# **Java Example 💻**

```java
// Memento
class Memento {
    private final String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

// Originator
class Originator {
    private String state;

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public Memento saveState() {
        return new Memento(state);
    }

    public void restoreState(Memento memento) {
        state = memento.getState();
    }
}

// Caretaker
class Caretaker {
    private final List<Memento> mementos = new ArrayList<>();

    public void addMemento(Memento memento) {
        mementos.add(memento);
    }

    public Memento getMemento(int index) {
        return mementos.get(index);
    }
}

// Usage
public class Main {
    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();

        originator.setState("State #1");
        caretaker.addMemento(originator.saveState());

        originator.setState("State #2");
        caretaker.addMemento(originator.saveState());

        originator.setState("State #3");

        // Undo to previous state
        originator.restoreState(caretaker.getMemento(0));
        System.out.println("Restored: " + originator.getState());
    }
}
```

**Output:**

```
Restored: State #1
```

---

# **When to use? 🚀**

* Undo/redo functionality (text editors, games, drawing tools)
* Save checkpoints
* Avoid exposing internal object state

---

# **Key Points 🎯**

* ✅ Keeps encapsulation intact
* ✅ Easy rollback mechanism
* ❌ Can use a lot of memory if too many mementos

---
