# 🧠 **Template Method Design Pattern**

| 🔧                     | Details                                                                           |
| ---------------------- | --------------------------------------------------------------------------------- |
| **Type**               | Behavioral Pattern                                                                |
| **Problem Solved**     | Define the **skeleton** of an algorithm and let subclasses **fill in the blanks** |
| **Real World Analogy** | Making tea vs. coffee: **boil water → brew → pour → add condiments**              |
| **Also Known As**      | Hollywood Principle ("Don't call us, we'll call you")                             |

---

## 🎯 **Intent**

> Define the **framework of an algorithm** in a base class and let subclasses **customize certain steps** without changing the structure.

---

## 📦 **Core Idea**

* Define the common process steps in the **base class** 🧱
* Allow subclasses to **override specific steps**
* Helps **enforce consistency**, but still enables **customization**

---

# 📊 **UML Diagram**

```plaintext
+-----------------------+
|  AbstractClass        |
+-----------------------+
| templateMethod()      | <-- final algorithm
| + step1()             | <-- default / abstract
| + step2()             |
+-----------------------+
         ▲
         |
+-----------------------+
| ConcreteClassA        |
| + step1() override    |
+-----------------------+

+-----------------------+
| ConcreteClassB        |
| + step1() override    |
+-----------------------+
```

---

# 💡 **Real-World Example: Beverage Maker**

> Making **tea** and **coffee** follow similar steps:
>
> 1. Boil water
> 2. Brew (tea leaves or coffee powder)
> 3. Pour into cup
> 4. Add condiments

✅ Structure is fixed → customize brewing and condiments step

---

## 👨‍💻 Java Implementation

### 1️⃣ **Abstract Class (Template)**

```java
abstract class Beverage {
    // Template Method
    public final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    private void boilWater() {
        System.out.println("Boiling water...");
    }

    private void pourInCup() {
        System.out.println("Pouring into cup...");
    }

    // Steps to be overridden
    protected abstract void brew();
    protected abstract void addCondiments();
}
```

---

### 2️⃣ **Concrete Classes**

```java
class Tea extends Beverage {
    @Override
    protected void brew() {
        System.out.println("Steeping the tea...");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Adding lemon...");
    }
}

class Coffee extends Beverage {
    @Override
    protected void brew() {
        System.out.println("Dripping coffee through filter...");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Adding sugar and milk...");
    }
}
```

---

### 3️⃣ **Client Code**

```java
public class TemplateMethodDemo {
    public static void main(String[] args) {
        Beverage tea = new Tea();
        tea.prepareRecipe();

        System.out.println();

        Beverage coffee = new Coffee();
        coffee.prepareRecipe();
    }
}
```

---

## 📊 Output

```
Boiling water...
Steeping the tea...
Pouring into cup...
Adding lemon...

Boiling water...
Dripping coffee through filter...
Pouring into cup...
Adding sugar and milk...
```

---

# ✅ When to Use Template Method Pattern

| Scenario                                      | Benefit                                     |
| --------------------------------------------- | ------------------------------------------- |
| Reuse fixed structure but allow customization | Avoids duplicating common steps             |
| Enforce standard workflow                     | Maintain consistency across implementations |
| Frameworks & libraries                        | Offer hooks for custom steps                |

---

# ✅ Real-World Use Cases

| Use Case                      | How Template Pattern Helps                             |
| ----------------------------- | ------------------------------------------------------ |
| Report Generation             | Common steps like header/footer, variable body content |
| Online Payment Processing     | Fixed flow, flexible providers (PayPal, Stripe, etc.)  |
| Test Frameworks (JUnit, etc.) | `setup() → test() → teardown()`                        |
| HTML Rendering                | Common page layout, custom content block               |
| Game Development (game loop)  | Setup → run logic → cleanup                            |

---

# 🧪 Anti-pattern: Without Template

```java
public void makeTea() {
    boilWater();
    System.out.println("Steep tea...");
    pourInCup();
    System.out.println("Add lemon...");
}

public void makeCoffee() {
    boilWater();
    System.out.println("Drip coffee...");
    pourInCup();
    System.out.println("Add milk...");
}
```

❌ Duplicated logic for boil/pour
✅ Template solves this with shared structure

---

# 🧠 **Benefits of Template Pattern**

✅ Reduces **code duplication**
✅ Promotes **reusability** and **consistency**
✅ Subclasses control **variable behavior only**
✅ Implements **Hollywood Principle**: *Don't call us, we'll call you.*

---

# ⚠️ Disadvantages

* Can lead to **inflexible inheritance** (can't mix multiple behaviors easily)
* Harder to test if steps are tightly coupled
* Consider replacing with **Strategy pattern** if flexibility is more important

---

# 🧠 Template vs Strategy

| Aspect             | **Template Method**                | **Strategy**                                |
| ------------------ | ---------------------------------- | ------------------------------------------- |
| Behavior selection | At compile time via inheritance    | At runtime via composition                  |
| Structure          | Fixed algorithm in superclass      | Behavior defined in interchangeable classes |
| Flexibility        | Less (extends one class)           | More (inject any strategy at runtime)       |
| Inheritance used?  | ✅ Yes                              | ❌ No (uses composition)                     |
| Best for           | Fixed skeleton with variable parts | Pluggable algorithms                        |

---

# 🏗️ **System Design Example: Report Generator**

---

### 🎯 Problem

Design a system to generate **different types of reports**:

* PDF Report
* Excel Report
* HTML Report

✅ Common steps:

* Fetch Data
* Format Layout
* Export Output

---

### ✅ Apply Template Method Pattern

```java
abstract class ReportGenerator {
    public final void generateReport() {
        fetchData();
        formatReport();
        exportReport();
    }

    protected abstract void fetchData();
    protected abstract void formatReport();
    protected abstract void exportReport();
}
```

---

### Concrete Implementations

```java
class PDFReport extends ReportGenerator {
    protected void fetchData() {
        System.out.println("Fetching PDF data...");
    }

    protected void formatReport() {
        System.out.println("Formatting PDF layout...");
    }

    protected void exportReport() {
        System.out.println("Exporting to PDF...");
    }
}

class ExcelReport extends ReportGenerator {
    protected void fetchData() {
        System.out.println("Fetching Excel data...");
    }

    protected void formatReport() {
        System.out.println("Formatting Excel layout...");
    }

    protected void exportReport() {
        System.out.println("Exporting to Excel...");
    }
}
```

---

### Test Driver

```java
public class ReportDemo {
    public static void main(String[] args) {
        ReportGenerator pdf = new PDFReport();
        pdf.generateReport();

        System.out.println();

        ReportGenerator excel = new ExcelReport();
        excel.generateReport();
    }
}
```

---

## 📊 Output

```
Fetching PDF data...
Formatting PDF layout...
Exporting to PDF...

Fetching Excel data...
Formatting Excel layout...
Exporting to Excel...
```

---

# 💥 Interview Takeaways

✅ Explain with **beverage / report / framework** example
✅ Use term "**skeleton of algorithm**"
✅ Mention **final method + overridable hooks**
✅ Say it supports the **Open/Closed Principle**
✅ Great for **frameworks, SDKs, game engines**

---

# 🔥 MAANG-Level System Design Use Cases

| System              | Template Pattern Use                                 |
| ------------------- | ---------------------------------------------------- |
| Online Checkout     | `checkout()` → payment, inventory, invoice           |
| Analytics Pipelines | `process()` → validate, transform, aggregate         |
| Deployment Pipeline | `deploy()` → build → test → push → monitor           |
| CI/CD Workflows     | Define core pipeline structure, plugin custom stages |
| File Import Parsers | Common format → per type parsing steps               |

---

# 🏁 Summary

✅ Template Method = base class defines algorithm skeleton
✅ Subclasses override specific steps
✅ Used in reports, payments, testing frameworks
✅ Best for fixed workflows with custom steps
✅ Use when **structure is constant**, behavior varies

---

