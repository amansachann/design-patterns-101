package com.codewithaman.CreationalPatterns.SingletonPattern.SingletonMaster;

import java.io.Serial;
import java.io.Serializable;

public class Browser implements Serializable, Cloneable {

    // 1. Private static instance of the class
    private volatile static Browser browser;

    // 2. Private constructor to prevent direct object creation
    private Browser() {
        // To prevent reflection attacks
        if (browser != null) {
            throw new IllegalArgumentException("Object already exists");
        }
    }

    // 3. Public static method to get instance of this class
    public static Browser getInstance() {
        if (browser == null) {
            synchronized (Browser.class) {
                if (browser == null) {
                    browser = new Browser();
                }
            }
        }
        return browser;
    }

    // Other methods of the Browser class
    public void getInfo() {
        System.out.println("Browser information");
    }

    // Add read resolve method - called during deserialization
    @Serial
    protected Object readResolve() {
        return getInstance();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Singleton Object cannot be cloned");
    }
}
