# ♾ **Adapter Design Pattern**

| 🔧                     | Details                                          |
| ---------------------- | ------------------------------------------------ |
| **Type**               | Structural Pattern                               |
| **Problem Solved**     | Connect classes with **incompatible interfaces** |
| **Real-World Analogy** | 🌌 Power Adapter (EU plug fits into US socket)   |
| **Also Known As**      | Wrapper Pattern                                  |

---

## 🌟 **Intent**

> Convert the interface of a class into another interface clients expect.
> Adapter lets classes work together that couldn’t otherwise due to incompatible interfaces.

---

## 📦 **Core Idea**

* Use when two interfaces don’t match
* Create a **wrapper (adapter)** that sits in between
* Can be implemented via **Class Adapter (inheritance)** or **Object Adapter (composition)**

---

# 📊 **UML Diagram**

```plaintext
+--------------+        +------------------+       +---------------+
|  Client      | -----> |     Adapter      | ----> |  Adaptee       |
| (expects Target)     |  implements       |       | (existing code)|
+--------------+        |   Target         |       +---------------+
                       +------------------+
```

---

## 🔍 Real-World Analogy

| Scenario                          | Adapter Role                               |
| --------------------------------- | ------------------------------------------ |
| Laptop with EU plug in US socket  | Power adapter allows compatibility         |
| Phone charger with USB-C vs USB-A | Cable adapter changes interface            |
| Card reader with microSD + SD     | Same reader adapts to different card types |

---

## 👨‍💻 Java Example: Media Player ♫

### 1️⃣ Target Interface (Expected by client)

```java
public interface MediaPlayer {
    void play(String audioType, String fileName);
}
```

---

### 2️⃣ Adaptee (Existing incompatible class)

```java
public class AdvancedMediaPlayer {
    public void playVlc(String fileName) {
        System.out.println("Playing VLC: " + fileName);
    }
    public void playMp4(String fileName) {
        System.out.println("Playing MP4: " + fileName);
    }
}
```

---

### 3️⃣ Adapter Implementation

```java
public class MediaAdapter implements MediaPlayer {
    private AdvancedMediaPlayer advancedPlayer = new AdvancedMediaPlayer();

    public void play(String audioType, String fileName) {
        if(audioType.equalsIgnoreCase("vlc")) {
            advancedPlayer.playVlc(fileName);
        } else if(audioType.equalsIgnoreCase("mp4")) {
            advancedPlayer.playMp4(fileName);
        } else {
            System.out.println("Unsupported format: " + audioType);
        }
    }
}
```

---

### 4️⃣ Client using Adapter

```java
public class AudioPlayer implements MediaPlayer {
    private MediaAdapter adapter = new MediaAdapter();

    public void play(String audioType, String fileName) {
        if(audioType.equalsIgnoreCase("mp3")) {
            System.out.println("Playing MP3: " + fileName);
        } else {
            adapter.play(audioType, fileName);
        }
    }
}
```

---

### 🎓 Demo

```java
public class AdapterDemo {
    public static void main(String[] args) {
        AudioPlayer player = new AudioPlayer();
        player.play("mp3", "song.mp3");
        player.play("vlc", "video.vlc");
        player.play("mp4", "movie.mp4");
    }
}
```

---

## 📈 Output

```
Playing MP3: song.mp3
Playing VLC: video.vlc
Playing MP4: movie.mp4
```

---

# ✅ When to Use Adapter Pattern

| Situation                                    | Why Adapter Helps                            |
| -------------------------------------------- | -------------------------------------------- |
| Using legacy code with a new interface       | Avoid modifying existing implementation      |
| Integrating third-party library              | Wrap external API to fit your system         |
| Incompatible interfaces (e.g., UI framework) | Adapters allow reuse without rewriting logic |

---

# 🚀 System Design Use Cases

| System Component      | Adapter Utility                                      |
| --------------------- | ---------------------------------------------------- |
| Payment Gateway       | Adapt Razorpay, PayPal, Stripe to a common interface |
| File Parser           | Wrap XML, JSON, CSV readers                          |
| Logger Framework      | Bridge Log4j, SLF4J, Logback APIs                    |
| Hardware Driver Layer | Adapt generic OS interface to specific hardware      |

---

# 📅 Class Adapter vs Object Adapter

| Feature              | Class Adapter              | Object Adapter    |
| -------------------- | -------------------------- | ----------------- |
| Inheritance Used     | ✅ Yes                      | ❌ No              |
| Composition Used     | ❌ No                       | ✅ Yes             |
| Reusable with others | ❌ Limited (tight coupling) | ✅ Highly reusable |
| Flexibility          | ❌ Rigid                    | ✅ More flexible   |

> 🔗 **Object Adapter is preferred** in most modern designs due to flexibility and maintainability.

---

# ✅ Pros & Cons

| ✅ Advantages                        | ❌ Disadvantages                          |
| ----------------------------------- | ---------------------------------------- |
| Reuse existing incompatible classes | Adds extra layer of indirection          |
| Works with third-party APIs         | May result in many small adapter classes |
| Promotes separation of concerns     | Not always easy with complex interfaces  |

---

# 👩‍💼 Interview Tips

✅ Explain **intent**: Match incompatible interfaces<br>
✅ Differentiate **Class vs Object Adapter**<br>
✅ Give **real-world analogy**: power adapter<br>
✅ Mention use cases in **integration or legacy wrapping**<br>
✅ Highlight preference for **object adapter** in Java

---

# 🏁 Summary

✅ Adapter = Bridge between incompatible interfaces  
✅ Use for legacy integration, third-party wrapping  
✅ Prefer object composition over inheritance  
✅ Common in APIs, file parsers, payment gateways  
✅ One of the **most asked** structural patterns
