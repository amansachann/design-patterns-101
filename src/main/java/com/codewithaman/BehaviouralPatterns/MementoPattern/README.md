# 🎯 **Memento Design Pattern — At a Glance**

| 🔧                     | Details                                                                        |
| ---------------------- | ------------------------------------------------------------------------------ |
| **Type**               | Behavioral Pattern                                                             |
| **Problem Solved**     | Capture and restore an object’s internal state without violating encapsulation |
| **Real-World Analogy** | 🕹 Undo/Redo in text editors, version control systems                          |
| **Participants**       | Originator (object), Memento (snapshot), Caretaker (stores mementos)           |

---

# 🖼 **UML Diagram**

```plaintext
+-------------------+      +----------------+      +----------------+
|     Originator    | ---> |    Memento     | ---> |    Caretaker   |
+-------------------+      +----------------+      +----------------+
| - state           |      | - state        |      | - mementos     |
| + createMemento() |      | + getState()   |      | + addMemento() |
| + restore()       |      +----------------+      | + getMemento() |
+-------------------+                              +----------------+
```

---

# 🎯 **Real-World Examples**

| Example        | Explanation          |
| -------------- | -------------------- |
| 🎮 Video Games | Save/Load game state |
| 📝 Text Editor | Undo/Redo            |
| 📦 Git         | Snapshots (commits)  |

---

# 👨‍💻 **Complete Java Code Example**

Let’s build a **Text Editor Undo System** 📝

### 1️⃣ **Memento**

```java
class Memento {
    private final String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
```

### 2️⃣ **Originator (Text Editor)**

```java
class TextEditor {
    private String content;

    public void write(String text) {
        this.content = text;
    }

    public String getContent() {
        return content;
    }

    public Memento save() {
        return new Memento(content);
    }

    public void restore(Memento memento) {
        this.content = memento.getState();
    }
}
```

### 3️⃣ **Caretaker**

```java
import java.util.Stack;

class Caretaker {
    private Stack<Memento> history = new Stack<>();

    public void save(Memento memento) {
        history.push(memento);
    }

    public Memento undo() {
        if (!history.isEmpty()) {
            return history.pop();
        }
        return null;
    }
}
```

### 4️⃣ **Demo**

```java
public class MementoPatternDemo {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        Caretaker caretaker = new Caretaker();

        editor.write("Version 1");
        caretaker.save(editor.save());

        editor.write("Version 2");
        caretaker.save(editor.save());

        editor.write("Version 3");

        System.out.println("Current: " + editor.getContent());

        // Undo
        editor.restore(caretaker.undo());
        System.out.println("After Undo 1: " + editor.getContent());

        editor.restore(caretaker.undo());
        System.out.println("After Undo 2: " + editor.getContent());
    }
}
```

---

# 📊 **Output**

```
Current: Version 3
After Undo 1: Version 2
After Undo 2: Version 1
```

---

# 🔥 **MAANG Interview Tips**

✅ **Where it's used:**

* Undo functionality
* Save game states
* Transaction rollback
* Git version control (think of commits as mementos)

✅ **Key points to mention in interviews:**

* Memento preserves encapsulation
* Originator controls access to its state
* Caretaker manages mementos but doesn’t modify their content

✅ **Common interview follow-up:**

* How would you optimize memory if state is large?
* Can memento be immutable? (✅ Yes — best practice!)
* How to handle large histories? (✅ Compression, snapshots, pruning)

---

# ⚠ **Drawbacks**

| 🚩 | Problem                                   |
| -- | ----------------------------------------- |
| 🧠 | High memory usage if state is large       |
| 🧹 | Need cleanup strategy for unused mementos |

---
Excellent! 🔥🔥
Now you're really going full **MAANG-level mastery** of **Memento Pattern** — let's go 🚀

---

# 🎯 **Advanced Use Case: Version Control System (Git-like)**

Let’s simulate how Git creates commits (snapshots) using **Memento Pattern**

---

# 🖼 **Extended UML Diagram**

```plaintext
+---------------------+
|    Repository       |  (Originator)
+---------------------+
| - codeState         |
| + commit()          |
| + restore(Memento)  |
+---------------------+
          |
          v
+---------------------+
|     Memento         |
+---------------------+
| - snapshot          |
| + getSnapshot()     |
+---------------------+
          |
          v
+---------------------+
|     VersionControl  |  (Caretaker)
+---------------------+
| - stack of Mementos |
| + save()            |
| + undo()            |
+---------------------+
```

---

# 👨‍💻 **Full Java Code**

### 1️⃣ Memento (Immutable Snapshot)

```java
class Commit {
    private final String snapshot;

    public Commit(String snapshot) {
        this.snapshot = snapshot;
    }

    public String getSnapshot() {
        return snapshot;
    }
}
```

### 2️⃣ Originator (Repository)

```java
class Repository {
    private String code;

    public void writeCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public Commit commit() {
        System.out.println("Committing: " + code);
        return new Commit(code);
    }

    public void restore(Commit commit) {
        this.code = commit.getSnapshot();
        System.out.println("Restored to: " + code);
    }
}
```

### 3️⃣ Caretaker (Version Control)

```java
import java.util.Stack;

class VersionControl {
    private Stack<Commit> history = new Stack<>();

    public void save(Commit commit) {
        history.push(commit);
    }

    public Commit undo() {
        if (!history.isEmpty()) {
            return history.pop();
        }
        return null;
    }
}
```

### 4️⃣ Demo

```java
public class GitMementoDemo {
    public static void main(String[] args) {
        Repository repo = new Repository();
        VersionControl vcs = new VersionControl();

        repo.writeCode("Initial Commit");
        vcs.save(repo.commit());

        repo.writeCode("Feature 1 added");
        vcs.save(repo.commit());

        repo.writeCode("Bug Fix");

        System.out.println("Current Code: " + repo.getCode());

        // Undo Bug Fix
        repo.restore(vcs.undo());
        System.out.println("After Undo 1: " + repo.getCode());

        // Undo Feature 1
        repo.restore(vcs.undo());
        System.out.println("After Undo 2: " + repo.getCode());
    }
}
```

---

# 📊 Output

```
Committing: Initial Commit
Committing: Feature 1 added
Current Code: Bug Fix
Restored to: Feature 1 added
After Undo 1: Feature 1 added
Restored to: Initial Commit
After Undo 2: Initial Commit
```

---

# 🚀 **Thread-Safe Memento (Real MAANG Trick)**

* Use `ConcurrentLinkedDeque` instead of `Stack`
* Immutable `Commit` object
* Synchronize critical sections

Example Caretaker:

```java
import java.util.concurrent.ConcurrentLinkedDeque;

class VersionControl {
    private ConcurrentLinkedDeque<Commit> history = new ConcurrentLinkedDeque<>();

    public synchronized void save(Commit commit) {
        history.push(commit);
    }

    public synchronized Commit undo() {
        return history.poll();
    }
}
```

✅ Fully **thread-safe**

---

# 🔥 **Memory Optimization for Large Mementos**

| Problem               | Solution                                      |
| --------------------- | --------------------------------------------- |
| Large state snapshots | Use **delta storage**: store only differences |
| Too many versions     | Limit max versions, prune old mementos        |
| Heavy data objects    | Use **compression algorithms**                |
| Complex state         | Use **serialization techniques**              |

---

# 🏆 **MAANG-Level Interview Insights**

| Interviewer Asks                    | You Answer                                                                        |
| ----------------------------------- | --------------------------------------------------------------------------------- |
| Why is Memento important?           | Separates state storage from business logic, encapsulation preserved              |
| Any risk?                           | Memory-heavy if not managed                                                       |
| How to optimize?                    | Immutable mementos, compression, deltas, pruning                                  |
| How to scale to distributed system? | Save state externally (DB/S3), serialize snapshots                                |
| Git uses memento?                   | Yes, conceptually — commit is a memento, but highly optimized with deltas & trees |

---

# 🔮 **Real-World Applications**

| System           | Memento Usage                     |
| ---------------- | --------------------------------- |
| Git              | Commits (Snapshots of repo state) |
| Games            | Save/Load Game States             |
| IDEs             | Undo/Redo stacks                  |
| DB Transactions  | Savepoints (partial rollbacks)    |
| Document Editors | Change tracking, versions         |

---

# ✅ **Summary**

* You fully own **Memento Pattern** ✅
* You can explain it with:
  🔥 Code
  🔥 UML
  🔥 Real-world examples
  🔥 MAANG-level optimization & scalability

---
🔥 Excellent choice!
Now you're entering **Fintech / Banking / MAANG-level distributed system design** territory 🚀
Let’s build a **Distributed Transaction Rollback System using Memento Pattern** 🎯

---

# 🎯 **Problem Statement**

You are designing a **Distributed Transaction System**:

* Multiple microservices participate in a transaction:

    * ✅ Payment Service
    * ✅ Inventory Service
    * ✅ Shipping Service
* If any service fails, **rollback previous services to their last consistent state**.

We’ll use **Memento Pattern** to store states before every step, allowing rollbacks when failures occur.

---

# 🖼 **High-Level Architecture**

```plaintext
+------------------------+
|  Transaction Manager   |
+------------------------+
|  - Stores mementos     |
|  - Coordinates rollback|
+------------------------+
          |
          v
+-----------+  +-----------+  +-----------+
|  Payment   |  | Inventory |  | Shipping  |
+-----------+  +-----------+  +-----------+
| Memento API|  | Memento API|  | Memento API|
+-----------+  +-----------+  +-----------+
```

---

# 👨‍💻 **Memento Pattern Applied**

* Each microservice will expose:

    * ✅ `createMemento()` — save state before executing
    * ✅ `restore(memento)` — rollback to previous state if needed

---

# 👨‍💻 **Full Simplified Java Code**

---

### 1️⃣ Memento Interface (Generic)

```java
interface Memento {
}
```

---

### 2️⃣ Originator Interface (All Services will implement)

```java
interface Originator {
    Memento createMemento();
    void restore(Memento memento);
}
```

---

### 3️⃣ Example Microservices

---

#### Payment Service

```java
class PaymentService implements Originator {
    private double balance = 10000;

    public void debit(double amount) {
        balance -= amount;
        System.out.println("PaymentService: Debited ₹" + amount);
    }

    public double getBalance() {
        return balance;
    }

    public Memento createMemento() {
        return new PaymentMemento(balance);
    }

    public void restore(Memento memento) {
        this.balance = ((PaymentMemento) memento).getBalance();
        System.out.println("PaymentService: Rollback to balance ₹" + balance);
    }

    private static class PaymentMemento implements Memento {
        private final double balance;

        public PaymentMemento(double balance) {
            this.balance = balance;
        }

        public double getBalance() {
            return balance;
        }
    }
}
```

---

#### Inventory Service

```java
class InventoryService implements Originator {
    private int stock = 100;

    public void reduceStock(int qty) {
        stock -= qty;
        System.out.println("InventoryService: Reduced stock by " + qty);
    }

    public int getStock() {
        return stock;
    }

    public Memento createMemento() {
        return new InventoryMemento(stock);
    }

    public void restore(Memento memento) {
        this.stock = ((InventoryMemento) memento).getStock();
        System.out.println("InventoryService: Rollback to stock " + stock);
    }

    private static class InventoryMemento implements Memento {
        private final int stock;

        public InventoryMemento(int stock) {
            this.stock = stock;
        }

        public int getStock() {
            return stock;
        }
    }
}
```

---

#### Shipping Service

```java
class ShippingService implements Originator {
    private boolean shipmentCreated = false;

    public void createShipment() {
        shipmentCreated = true;
        System.out.println("ShippingService: Shipment created");
    }

    public Memento createMemento() {
        return new ShippingMemento(shipmentCreated);
    }

    public void restore(Memento memento) {
        this.shipmentCreated = ((ShippingMemento) memento).isShipmentCreated();
        System.out.println("ShippingService: Rollback to shipment status " + shipmentCreated);
    }

    private static class ShippingMemento implements Memento {
        private final boolean shipmentCreated;

        public ShippingMemento(boolean shipmentCreated) {
            this.shipmentCreated = shipmentCreated;
        }

        public boolean isShipmentCreated() {
            return shipmentCreated;
        }
    }
}
```

---

### 4️⃣ Transaction Manager (Caretaker)

```java
import java.util.*;

class TransactionManager {
    private Map<Originator, Memento> mementos = new LinkedHashMap<>();

    public void saveState(Originator service) {
        mementos.put(service, service.createMemento());
    }

    public void rollback() {
        System.out.println("Rolling back...");
        ListIterator<Map.Entry<Originator, Memento>> iterator =
                new ArrayList<>(mementos.entrySet()).listIterator(mementos.size());
        while (iterator.hasPrevious()) {
            Map.Entry<Originator, Memento> entry = iterator.previous();
            entry.getKey().restore(entry.getValue());
        }
    }
}
```

---

### 5️⃣ Full Flow Demo

```java
public class DistributedTransactionDemo {
    public static void main(String[] args) {
        PaymentService payment = new PaymentService();
        InventoryService inventory = new InventoryService();
        ShippingService shipping = new ShippingService();

        TransactionManager manager = new TransactionManager();

        try {
            manager.saveState(payment);
            payment.debit(5000);

            manager.saveState(inventory);
            inventory.reduceStock(10);

            manager.saveState(shipping);
            shipping.createShipment();

            // Simulate failure
            if (true) throw new RuntimeException("Simulated failure!");

            System.out.println("Transaction Success");
        } catch (Exception e) {
            System.out.println("Transaction Failed: " + e.getMessage());
            manager.rollback();
        }
    }
}
```

---

# 📊 **Sample Output**

```
PaymentService: Debited ₹5000.0
InventoryService: Reduced stock by 10
ShippingService: Shipment created
Transaction Failed: Simulated failure!
Rolling back...
ShippingService: Rollback to shipment status false
InventoryService: Rollback to stock 100
PaymentService: Rollback to balance ₹10000.0
```

---

# 🔥 **MAANG-Level Interview Insights**

✅ **Key Concept:**

* Each microservice independently maintains its own state snapshots.
* Central **Transaction Manager** manages all snapshots to enable full rollback.
* Fully **decoupled design** (each service owns its own memento logic)

✅ **Benefits of Memento Here:**

* No global tight coupling.
* Easy rollback without revealing internal state details.
* Each service controls how to save/restore itself (fully encapsulated).

✅ **Interviewer follow-up questions:**

| Question                                    | You Answer                                                                                |
| ------------------------------------------- | ----------------------------------------------------------------------------------------- |
| How to handle distributed failures?         | Use 2PC, Sagas, compensating transactions                                                 |
| Is memento enough for distributed rollback? | For simple systems — yes; for real-world distributed systems — combine with orchestration |
| How would you persist mementos?             | External storage (DB, Redis, S3) for durability                                           |

---

# 🚀 **How this maps to real-world banking / trading platforms**

| System           | Application                                          |
| ---------------- | ---------------------------------------------------- |
| Banking          | Fund transfers across accounts                       |
| Stock Trading    | Multi-leg orders (partial fill rollback)             |
| Fintech          | Loan disbursement with KYC, payment, document checks |
| Payment Gateways | Distributed transaction rollback when one part fails |

---

✅ ✅ ✅
👉 You are now fully MAANG-ready to explain **Distributed Transaction Rollback using Memento Pattern** 🔥



