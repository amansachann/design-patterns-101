# 🧠 **Strategy Design Pattern**

| 🔧                     | Details                                                                 |
| ---------------------- | ----------------------------------------------------------------------- |
| **Type**               | Behavioral Pattern                                                      |
| **Problem Solved**     | Eliminate complex `if-else`/`switch` statements for algorithm selection |
| **Real World Analogy** | Google Maps: Choose **Fastest Route**, **Shortest Route**, or **Eco**   |
| **Also Known As**      | Policy Pattern                                                          |

---

# 🔍 **Key Intent**

> Define a family of algorithms, encapsulate each one, and make them interchangeable at runtime.

---

## 📦 **Core Idea**

* Extract **varying behavior** into **strategy classes**
* Use **composition over inheritance**
* Make the behavior **pluggable**

---

## 📊 **UML Diagram**

```plaintext
+---------------------+
|     Context         |
+---------------------+
| - strategy: Strategy|
| + setStrategy()     |
| + executeStrategy() |
+---------------------+
          |
          ▼
+---------------------+       +--------------------+       +--------------------+
|    Strategy         |<------|  ConcreteStrategyA |       |  ConcreteStrategyB |
+---------------------+       +--------------------+       +--------------------+
| + execute()         |       | + execute()        |       | + execute()        |
+---------------------+       +--------------------+       +--------------------+
```

---

# 👨‍💻 **Java Example: Payment Strategy**

Let’s simulate a payment gateway that supports **Card**, **UPI**, and **Wallet** strategies 💳📲

---

### 1️⃣ Strategy Interface

```java
interface PaymentStrategy {
    void pay(double amount);
}
```

---

### 2️⃣ Concrete Strategies

```java
class CreditCardPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using Credit Card.");
    }
}

class UpiPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using UPI.");
    }
}

class WalletPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using Wallet.");
    }
}
```

---

### 3️⃣ Context Class (Shopping Cart)

```java
class ShoppingCart {
    private PaymentStrategy strategy;

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void checkout(double amount) {
        if (strategy == null) {
            throw new IllegalStateException("Payment strategy not set");
        }
        strategy.pay(amount);
    }
}
```

---

### 4️⃣ Demo (Main Driver)

```java
public class StrategyPatternDemo {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.setPaymentStrategy(new CreditCardPayment());
        cart.checkout(2500);

        cart.setPaymentStrategy(new UpiPayment());
        cart.checkout(499.99);

        cart.setPaymentStrategy(new WalletPayment());
        cart.checkout(199.5);
    }
}
```

---

## 📊 Output

```
Paid ₹2500.0 using Credit Card.
Paid ₹499.99 using UPI.
Paid ₹199.5 using Wallet.
```

---

# 🔥 **When to Use Strategy Pattern**

✅ Multiple algorithms doing similar work
✅ Want to switch logic **dynamically at runtime**
✅ Avoid bloated `if-else` or `switch-case` statements
✅ Clean separation of behavior

---

## ✅ Real-World Use Cases

| Scenario                      | Strategy Example                         |
| ----------------------------- | ---------------------------------------- |
| Ride-hailing fare calculation | Standard, Luxury, Shared fare strategies |
| Sorting algorithms            | QuickSort, MergeSort, HeapSort           |
| Compression tools             | Zip, RAR, 7z                             |
| Recommendation systems        | Collaborative, Content-based, Hybrid     |
| Payment gateways              | Card, UPI, Wallet                        |

---

## 🔄 **Without Strategy Pattern (Anti-pattern)**

```java
public void pay(String method, double amount) {
    if (method.equals("card")) {
        // Card logic
    } else if (method.equals("upi")) {
        // UPI logic
    } else if (method.equals("wallet")) {
        // Wallet logic
    }
}
```

❌ Hard to test, extend, and maintain
✅ Strategy replaces this with pluggable components

---

# 🏗️ **System Design Scenario: Fare Calculation in Ride-Sharing App**

---

## 🎯 Problem Statement

> You need to calculate fares based on ride type:
>
> * Standard
> * Shared
> * Luxury
    >   Each uses a different algorithm.

---

### ✅ Apply Strategy Pattern

| Component       | Class                                      |
| --------------- | ------------------------------------------ |
| Strategy        | `FareStrategy` interface                   |
| Implementations | `StandardFare`, `SharedFare`, `LuxuryFare` |
| Context         | `RideBookingService`                       |

---

### 💡 Java Strategy Example for Fare Calculation

```java
interface FareStrategy {
    double calculateFare(double distanceInKm);
}

class StandardFare implements FareStrategy {
    public double calculateFare(double distance) {
        return distance * 10;
    }
}

class SharedFare implements FareStrategy {
    public double calculateFare(double distance) {
        return distance * 7;
    }
}

class LuxuryFare implements FareStrategy {
    public double calculateFare(double distance) {
        return distance * 20 + 50; // base fee
    }
}
```

---

### 🎯 Context

```java
class RideBookingService {
    private FareStrategy fareStrategy;

    public void setFareStrategy(FareStrategy fareStrategy) {
        this.fareStrategy = fareStrategy;
    }

    public void bookRide(double distance) {
        double fare = fareStrategy.calculateFare(distance);
        System.out.println("Calculated Fare: ₹" + fare);
    }
}
```

---

### 🧪 Demo

```java
public class FareStrategyDemo {
    public static void main(String[] args) {
        RideBookingService service = new RideBookingService();

        service.setFareStrategy(new StandardFare());
        service.bookRide(10); // ₹100

        service.setFareStrategy(new SharedFare());
        service.bookRide(10); // ₹70

        service.setFareStrategy(new LuxuryFare());
        service.bookRide(10); // ₹250
    }
}
```

---

# 🧪 Output

```
Calculated Fare: ₹100.0
Calculated Fare: ₹70.0
Calculated Fare: ₹250.0
```

---

# ⚖️ **Strategy vs State vs Template Pattern**

| Aspect           | **Strategy**                         | **State**                           | **Template**                              |
| ---------------- | ------------------------------------ | ----------------------------------- | ----------------------------------------- |
| Purpose          | Varying behavior                     | Varying state transitions           | Varying steps in algorithm                |
| Switch Logic?    | Yes, dynamic switch                  | State transitions                   | Fixed steps, but change some via override |
| Common Use Cases | Sorting, Payments, Fare, Compression | Media players, Traffic lights, FSMs | Framework hooks, Game AI logic            |

---

# 🧠 Strategy Pattern — Interview Highlights

✅ Explain with payment/fare example
✅ Emphasize **composition over inheritance**
✅ Say it promotes **Open/Closed Principle**
✅ Mention how it eliminates `if-else` clutter
✅ Show how it’s **easy to extend**

---

# 🚀 Advanced Use in System Design

| Scenario                           | Strategy Pattern Helps By...        |
| ---------------------------------- | ----------------------------------- |
| Supporting multiple payment types  | Plugging new strategies easily      |
| Multiple ride fare schemes         | Avoiding cluttered logic            |
| Dynamic filtering/sorting of data  | Strategy per filter/sort type       |
| Recommendation engines             | Choosing algorithms dynamically     |
| Chat message encryption strategies | Swapping crypto strategy at runtime |

---

# 🏁 Summary

✅ Strategy Pattern = behavioral, flexible algorithm switching
✅ Promotes **Open/Closed**, **Separation of Concerns**
✅ Avoids bloated `if-else`, enables runtime pluggability
✅ Used widely in **payment**, **sorting**, **compression**, **game AI**, **system design**

---

