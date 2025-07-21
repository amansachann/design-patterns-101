# 🧠 **Iterator Design Pattern**

| 🔧                     | Details                                                                   |
| ---------------------- | ------------------------------------------------------------------------- |
| **Type**               | Behavioral Pattern                                                        |
| **Problem Solved**     | Access elements of a collection **sequentially** without exposing details |
| **Real World Analogy** | **TV Remote** channel changer: Moves from one channel to the next         |
| **Also Known As**      | Cursor Pattern                                                            |

---

## 🎯 **Intent**

> Provide a way to **access elements** of a collection object sequentially **without exposing its internal structure**.

---

# 📦 **Core Idea**

* Hide internal structure of collection 🔐
* Allow iteration without exposing internal details
* Enables **uniform traversal** for different data structures (Array, List, Tree, Graph, etc.)

---

# 📊 **UML Diagram**

```plaintext
+-------------------+     uses     +-------------------------+
|     Client        | <----------> |     Iterator            |
+-------------------+              +-------------------------+
                                  /|\       + next()         |
                                   |        + hasNext()      |
+-------------------+             |        + current()       |
| Aggregate (List)  |-------------+        + reset() (opt.)  |
+-------------------+                      +-----------------+
| + createIterator()|
+-------------------+
```

---

# 💡 **Real-World Example: Music Playlist**

> A music playlist is a collection.
> You use the **next()**, **previous()**, **hasNext()** buttons to navigate.

✅ Playlist = Aggregate
✅ Buttons = Iterator

---

## 👨‍💻 **Java Implementation: Name Collection**

Let’s create a simple collection of names with a custom iterator.

---

### 1️⃣ **Iterator Interface**

```java
interface Iterator<T> {
    boolean hasNext();
    T next();
}
```

---

### 2️⃣ **Aggregate Interface**

```java
interface IterableCollection<T> {
    Iterator<T> createIterator();
}
```

---

### 3️⃣ **Concrete Collection (Name Repository)**

```java
class NameRepository implements IterableCollection<String> {
    private String[] names = { "Aman", "Sachin", "Vikas", "Neha" };

    @Override
    public Iterator<String> createIterator() {
        return new NameIterator();
    }

    private class NameIterator implements Iterator<String> {
        int index = 0;

        public boolean hasNext() {
            return index < names.length;
        }

        public String next() {
            if (this.hasNext()) {
                return names[index++];
            }
            return null;
        }
    }
}
```

---

### 4️⃣ **Client Code (Demo)**

```java
public class IteratorPatternDemo {
    public static void main(String[] args) {
        NameRepository repo = new NameRepository();
        Iterator<String> iterator = repo.createIterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
```

---

## 📊 Output

```
Aman
Sachin
Vikas
Neha
```

---

# ✅ When to Use Iterator Pattern

| Situation                                                  | Why Iterator Helps                     |
| ---------------------------------------------------------- | -------------------------------------- |
| Need to **traverse a collection**                          | Iterator hides internal representation |
| You want to **decouple collection structure**              | Allows uniform access                  |
| Need to **customize traversal** (e.g., reverse, filtering) | Create different iterator types        |

---

# ✅ Real-World Use Cases

| System                          | Iterator Usage                       |
| ------------------------------- | ------------------------------------ |
| File Browsers                   | Navigate files/folders               |
| Media Players                   | Playlist navigation                  |
| Social Media Feed               | Iterate through posts/stories        |
| Database Cursor (JDBC)          | Iterate through query results        |
| Tree Traversal (DOM, JSON, XML) | Iterate over hierarchical structures |

---

# 🧠 Java's Built-in Iterators

```java
List<String> names = Arrays.asList("Aman", "Sachin", "Neha");

Iterator<String> iterator = names.iterator();
while (iterator.hasNext()) {
    System.out.println(iterator.next());
}
```

✅ **List, Set, Map** all implement `Iterable<T>`
✅ Enhanced `for-each` loop internally uses Iterator

---

# 🧪 Advanced: Filter Iterator

```java
class EvenNumberIterator implements Iterator<Integer> {
    private List<Integer> list;
    private int index = 0;

    public EvenNumberIterator(List<Integer> list) {
        this.list = list;
        moveToNextEven();
    }

    private void moveToNextEven() {
        while (index < list.size() && list.get(index) % 2 != 0) {
            index++;
        }
    }

    public boolean hasNext() {
        return index < list.size();
    }

    public Integer next() {
        int value = list.get(index++);
        moveToNextEven();
        return value;
    }
}
```

---

# 🏗️ **System Design Scenario: Custom Feed Engine**

---

## 🎯 Problem

You need to design a **custom feed system** (like LinkedIn/Twitter) that:

* Loads data in **batches**
* Filters based on **engagement or type**
* Provides **pagination**

---

### ✅ Use Iterator Pattern

| Component  | Class                                             |
| ---------- | ------------------------------------------------- |
| Collection | `FeedCollection`                                  |
| Iterator   | `FeedIterator`, `BatchIterator`, `FilterIterator` |
| Client     | `FeedService`                                     |

---

## 🧠 Benefits in System Design

✅ Decouples traversal from logic
✅ Allows pre-fetching or lazy loading
✅ Adds filters, limits, pagination easily
✅ Used heavily in **microservices** & **streaming systems**

---

# 🧠 Iterator vs Other Patterns

| Pattern             | Purpose                               |
| ------------------- | ------------------------------------- |
| **Iterator**        | Sequential traversal over elements    |
| **Strategy**        | Swap algorithms dynamically           |
| **Template Method** | Fix skeleton, override specific steps |
| **Observer**        | Notify on state changes               |
| **Command**         | Encapsulate a request as an object    |

---

# ✅ Benefits of Iterator Pattern

✅ Promotes **Single Responsibility Principle**
✅ Abstracts **how** traversal is done
✅ Uniform interface for different collections
✅ Easily extendable (e.g., reverse, skip, filter)

---

# ⚠ Disadvantages

❌ Additional classes
❌ Not ideal for **very large datasets** unless lazy loading or pagination used

---

# 🔥 Interview Insights

✅ Used internally in all **Collection APIs**
✅ Frequently asked in **LLD interviews**:

> “Design your own ArrayList and support custom iterators.”

✅ Ideal follow-up:

> “How can you implement pagination using Iterator?”

---

# 💥 MAANG-Level Takeaway

| Feature             | Command Pattern Use Case              |
| ------------------- | ------------------------------------- |
| 🎯 Traversal        | Next/Prev for lists, playlists, feeds |
| 📊 Custom Filters   | Even numbers, video posts, etc.       |
| 📦 Batch Pagination | `nextBatch()`, `hasMore()`            |
| ⚙️ Lazy Loading     | Load data only when needed            |

---

# 🏁 Summary

✅ Iterator Pattern = access collection items **one by one**
✅ Hides **internal structure**, supports custom iteration logic
✅ Supports **filtering**, **pagination**, **lazy loading**
✅ Used in **collections**, **feeds**, **file explorers**, **database cursors**

---

