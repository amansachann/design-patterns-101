
# 🧠 **Builder Design Pattern**

| 🔧                     | Details                                                                      |
| ---------------------- | ---------------------------------------------------------------------------- |
| **Type**               | Creational Pattern                                                           |
| **Problem Solved**     | Constructing **complex objects step-by-step** without confusing constructors |
| **Real-World Analogy** | 🛠️ **Ordering a Burger**: Choose bun, patty, sauce, toppings...             |
| **Also Known As**      | Step-by-step object construction                                             |

---

## 🎯 **Intent**

> Separate the construction of a complex object from its representation so that the same construction process can create different representations.

---

## 📦 **Core Idea**

* Hide complex constructor logic
* Use **step-by-step method chaining**
* Promote **immutability**, readability, flexibility
* Useful when object has many optional fields

---

# 📊 **UML Diagram**

```plaintext
+---------------------+
|     Director        | ← Optional
+---------------------+
| - builder: Builder  |
| + construct()       |
+---------------------+
          |
          v
+---------------------+        +------------------------+
|     Builder         |<────── |   ConcreteBuilder      |
+---------------------+        +------------------------+
| + setPartA()        |        | + setPartA()           |
| + setPartB()        |        | + setPartB()           |
| + getResult()       |        | + getResult()          |
+---------------------+        +------------------------+
                                    |
                                    v
                           +-------------------+
                           |     Product       |
                           +-------------------+
```

---

## 💡 **Real-World Example: Creating a Burger 🍔**

> You build your burger by choosing:
>
> * Bun 🍞
> * Patty 🍖
> * Sauce 🥫
> * Cheese 🧀
> * Veggies 🥬

Each step customizes the final burger 🍔

---

## 👨‍💻 Java Implementation

---

### 1️⃣ **Product (Burger)**

```java
public class Burger {
    private String bun;
    private String patty;
    private boolean cheese;
    private boolean lettuce;

    public Burger(String bun, String patty, boolean cheese, boolean lettuce) {
        this.bun = bun;
        this.patty = patty;
        this.cheese = cheese;
        this.lettuce = lettuce;
    }

    @Override
    public String toString() {
        return "🍔 Burger with " + bun + ", " + patty +
               (cheese ? ", cheese" : "") +
               (lettuce ? ", lettuce" : "");
    }
}
```

---

### 2️⃣ **Builder Class**

```java
public class BurgerBuilder {
    private String bun;
    private String patty;
    private boolean cheese;
    private boolean lettuce;

    public BurgerBuilder setBun(String bun) {
        this.bun = bun;
        return this;
    }

    public BurgerBuilder setPatty(String patty) {
        this.patty = patty;
        return this;
    }

    public BurgerBuilder addCheese(boolean cheese) {
        this.cheese = cheese;
        return this;
    }

    public BurgerBuilder addLettuce(boolean lettuce) {
        this.lettuce = lettuce;
        return this;
    }

    public Burger build() {
        return new Burger(bun, patty, cheese, lettuce);
    }
}
```

---

### 3️⃣ **Client Code**

```java
public class BuilderDemo {
    public static void main(String[] args) {
        Burger burger = new BurgerBuilder()
                .setBun("Sesame Bun")
                .setPatty("Chicken Patty")
                .addCheese(true)
                .addLettuce(true)
                .build();

        System.out.println(burger);
    }
}
```

---

## 📊 Output

```
🍔 Burger with Sesame Bun, Chicken Patty, cheese, lettuce
```

---

# ✅ When to Use Builder Pattern

| Scenario                                   | Why Builder Helps                      |
| ------------------------------------------ | -------------------------------------- |
| Object has many **optional fields**        | Avoids constructor overloading hell 😱 |
| You need **immutable objects**             | Object built in final step             |
| Construction involves **validation/steps** | Steps handled separately               |
| You want **readable chained setters**      | Fluent interface with `.build()`       |

---

# ✅ Real-World Use Cases

| System               | Builder Usage                          |
| -------------------- | -------------------------------------- |
| UI Layout Engines    | Build UI components                    |
| HTTP Client          | Build request with headers, body, etc. |
| Game Engines         | Build custom characters or maps        |
| Object Mapping Tools | Map DTOs with optional properties      |
| Test Data Builders   | Prepare mock test data                 |

---

# 💎 Builder Pattern in Java Standard API

| Class                | Pattern Used              |
| -------------------- | ------------------------- |
| `StringBuilder`      | Chained `.append()` calls |
| `Calendar.Builder`   | Step-by-step calendar     |
| `javax.ws.rs.client` | Fluent request builder    |
| `Lombok @Builder`    | Auto-generates builder    |

---

# 💼 System Design Example: `HttpRequest` Builder

---

```java
HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create("https://example.com"))
        .header("Content-Type", "application/json")
        .POST(HttpRequest.BodyPublishers.ofString("{ \"name\": \"Aman\" }"))
        .build();
```

✅ Each method modifies config  
✅ `.build()` finalizes the request  
✅ Avoids constructor with 10+ params!  

---

# ✅ Pros and Cons

| ✅ Advantages                             | ❌ Disadvantages                      |
| ---------------------------------------- | ------------------------------------ |
| Improves code **readability**            | Extra builder class needed           |
| Supports **immutable objects**           | Slightly more verbose                |
| Avoids **constructor explosion**         | Easy to misuse if validation skipped |
| Encourages **step-by-step construction** |                                      |

---

# 🧠 Builder vs Factory vs Prototype

| Pattern       | Focus                  | Use Case                                 |
| ------------- | ---------------------- | ---------------------------------------- |
| **Builder**   | Step-by-step build     | Object with many optional configurations |
| **Factory**   | Select product variant | Return one of many subclasses            |
| **Prototype** | Clone an object        | Copy existing object                     |

---

# 🏁 Summary

✅ Builder Pattern = step-by-step construction  
✅ Improves **readability**, **testability**, **immutability**  
✅ Avoids constructor overloads  
✅ Ideal for **complex, optional, nested configurations**  
✅ Used heavily in **REST clients**, **UI**, **POJO building**, **Lombok**  

---

