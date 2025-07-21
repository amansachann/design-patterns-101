
# 🧠 **State Design Pattern**

| 🔧                     | Details                                                                   |
| ---------------------- | ------------------------------------------------------------------------- |
| **Type**               | Behavioral Pattern                                                        |
| **Problem Solved**     | Let an object **change its behavior** when its internal **state changes** |
| **Real World Analogy** | **Traffic Light** 🚦 (Red → Green → Yellow → Red...)                      |
| **Also Known As**      | Object State Pattern                                                      |

---

## 🎯 **Intent**

> Allow an object to alter its **behavior** when its **state changes**, appearing as if it changed its class.

---

## 📦 **Core Idea**

* Encapsulate **states** into **classes**
* Let the **context delegate behavior** to current state
* Avoids messy `if-else` or `switch` blocks

---

# 📊 **UML Diagram**

```plaintext
+-----------------+
|     Context     |
+-----------------+
| - state: State  |
| + setState()    |
| + request()     | -----> delegates to current state
+-----------------+
         ▲
         |
+----------------+
|     State      | (interface)
+----------------+
| + handle()     |
+----------------+
     ▲     ▲
     |     |
+---------+---------+
| ConcreteStateA    |
| ConcreteStateB    |
+-------------------+
```

---

# 💡 **Real-World Example: Vending Machine**

> A vending machine goes through states like:
>
> * Idle
> * Waiting for selection
> * Dispensing product
> * Out of stock

✅ Transitions cause behavior to change without needing `if-else`

---

## 👨‍💻 Java Example: Vending Machine 🎯

---

### 1️⃣ **State Interface**

```java
interface VendingMachineState {
    void insertCoin();
    void selectProduct();
    void dispense();
}
```

---

### 2️⃣ **Concrete States**

```java
class IdleState implements VendingMachineState {
    private VendingMachine machine;

    public IdleState(VendingMachine machine) {
        this.machine = machine;
    }

    public void insertCoin() {
        System.out.println("💰 Coin inserted.");
        machine.setState(machine.getHasCoinState());
    }

    public void selectProduct() {
        System.out.println("Insert coin first.");
    }

    public void dispense() {
        System.out.println("Insert coin and select product first.");
    }
}
```

```java
class HasCoinState implements VendingMachineState {
    private VendingMachine machine;

    public HasCoinState(VendingMachine machine) {
        this.machine = machine;
    }

    public void insertCoin() {
        System.out.println("Coin already inserted.");
    }

    public void selectProduct() {
        System.out.println("🛍️ Product selected.");
        machine.setState(machine.getDispensingState());
    }

    public void dispense() {
        System.out.println("Select product first.");
    }
}
```

```java
class DispensingState implements VendingMachineState {
    private VendingMachine machine;

    public DispensingState(VendingMachine machine) {
        this.machine = machine;
    }

    public void insertCoin() {
        System.out.println("Please wait, dispensing...");
    }

    public void selectProduct() {
        System.out.println("Already dispensing.");
    }

    public void dispense() {
        System.out.println("🍫 Dispensing product...");
        machine.setState(machine.getIdleState());
    }
}
```

---

### 3️⃣ **Context Class (VendingMachine)**

```java
class VendingMachine {
    private VendingMachineState idleState;
    private VendingMachineState hasCoinState;
    private VendingMachineState dispensingState;

    private VendingMachineState currentState;

    public VendingMachine() {
        idleState = new IdleState(this);
        hasCoinState = new HasCoinState(this);
        dispensingState = new DispensingState(this);

        currentState = idleState;
    }

    public void setState(VendingMachineState state) {
        currentState = state;
    }

    public VendingMachineState getIdleState() {
        return idleState;
    }

    public VendingMachineState getHasCoinState() {
        return hasCoinState;
    }

    public VendingMachineState getDispensingState() {
        return dispensingState;
    }

    public void insertCoin() {
        currentState.insertCoin();
    }

    public void selectProduct() {
        currentState.selectProduct();
    }

    public void dispense() {
        currentState.dispense();
    }
}
```

---

### 4️⃣ **Demo**

```java
public class StatePatternDemo {
    public static void main(String[] args) {
        VendingMachine machine = new VendingMachine();

        machine.insertCoin();
        machine.selectProduct();
        machine.dispense();
    }
}
```

---

## 📊 Output

```
💰 Coin inserted.
🛍️ Product selected.
🍫 Dispensing product...
```

---

# ✅ When to Use State Pattern

| Scenario                                     | Benefit                               |
| -------------------------------------------- | ------------------------------------- |
| Object has multiple **states**               | Avoids complex conditionals           |
| State-specific behavior changes              | Each state encapsulates its own logic |
| State transitions are **dynamic**            | Easily add/remove new states          |
| Need to follow **workflow** or **lifecycle** | Each step has its own state           |

---

# ✅ Real-World Use Cases

| System                       | State Pattern Usage                                 |
| ---------------------------- | --------------------------------------------------- |
| Vending Machines             | Idle, HasCoin, Dispensing, OutOfStock               |
| ATMs                         | NoCard, HasCard, Authenticated, TransactionComplete |
| Document Workflow            | Draft, Review, Approved, Published                  |
| Game Characters              | Idle, Walking, Running, Jumping                     |
| Order Lifecycle (E-Commerce) | Placed, Shipped, Delivered, Cancelled               |

---

# 🧠 Benefits of State Pattern

✅ Eliminates **bloated `if-else` or `switch-case` blocks**  
✅ Promotes **Single Responsibility Principle** — each state handles its own logic  
✅ Easy to add new states (supports **Open/Closed Principle**)  
✅ Enhances **readability** and **testability**  

---

# ⚠ Disadvantages

❌ Increases number of classes  
❌ State transitions may still need to be coordinated manually  

---

# 🏗️ System Design Example: Order Status Workflow

---

## 🎯 Problem

> Design a system to handle **Order Lifecycle**:
>
> * `Created` → `Paid` → `Shipped` → `Delivered`

✅ Each state should control what transitions are valid

---

### 🎯 Java Sketch

```java
interface OrderState {
    void next(OrderContext ctx);
    void cancel(OrderContext ctx);
}
```

```java
class CreatedState implements OrderState {
    public void next(OrderContext ctx) {
        System.out.println("✅ Order paid.");
        ctx.setState(new PaidState());
    }
    public void cancel(OrderContext ctx) {
        System.out.println("❌ Order canceled from Created.");
        ctx.setState(new CancelledState());
    }
}
```

```java
class PaidState implements OrderState {
    public void next(OrderContext ctx) {
        System.out.println("📦 Order shipped.");
        ctx.setState(new ShippedState());
    }
    public void cancel(OrderContext ctx) {
        System.out.println("❌ Cannot cancel after payment.");
    }
}
```

```java
class ShippedState implements OrderState {
    public void next(OrderContext ctx) {
        System.out.println("📬 Order delivered.");
        ctx.setState(new DeliveredState());
    }
    public void cancel(OrderContext ctx) {
        System.out.println("❌ Cannot cancel. Already shipped.");
    }
}
```

```java
class DeliveredState implements OrderState {
    public void next(OrderContext ctx) {
        System.out.println("Order already delivered.");
    }
    public void cancel(OrderContext ctx) {
        System.out.println("Cannot cancel delivered order.");
    }
}
```

```java
class CancelledState implements OrderState {
    public void next(OrderContext ctx) {
        System.out.println("Order already canceled.");
    }
    public void cancel(OrderContext ctx) {
        System.out.println("Already canceled.");
    }
}
```

```java
class OrderContext {
    private OrderState currentState;

    public OrderContext() {
        currentState = new CreatedState();
    }

    public void setState(OrderState state) {
        this.currentState = state;
    }

    public void next() {
        currentState.next(this);
    }

    public void cancel() {
        currentState.cancel(this);
    }
}
```

---

### Demo

```java
public class OrderWorkflow {
    public static void main(String[] args) {
        OrderContext order = new OrderContext();

        order.next();   // Pay
        order.next();   // Ship
        order.next();   // Deliver
        order.cancel(); // Invalid now
    }
}
```

---

## 📊 Output

```
✅ Order paid.
📦 Order shipped.
📬 Order delivered.
Cannot cancel delivered order.
```

---

# 🔥 MAANG-Level System Design Use Cases

| System           | State Pattern Use Case                        |
| ---------------- | --------------------------------------------- |
| Order Management | Order lifecycle states                        |
| Payment Gateway  | Payment: Created, Authorized, Settled, Failed |
| User Onboarding  | Pending → Verified → Active                   |
| Chat Application | User states: Online, Away, Offline            |
| Game AI          | Enemy: Patrol, Attack, Flee                   |

---

# 🧠 State vs Strategy vs Template

| Pattern      | Focus                       | Switched At    | Key Mechanism                |
| ------------ | --------------------------- | -------------- | ---------------------------- |
| **State**    | Object's behavior changes   | Based on state | Context holds state object   |
| **Strategy** | Switch algorithms           | At runtime     | Context uses strategy object |
| **Template** | Reuse skeleton of algorithm | Compile-time   | Subclass overrides methods   |

---

# 🏁 Summary

✅ State Pattern = object changes behavior with state  
✅ Ideal for workflows, lifecycles, complex UI states  
✅ Removes ugly `if-else` blocks  
✅ Supports Open/Closed Principle  
✅ Frequently used in **games**, **order processing**, **onboarding systems**

---

