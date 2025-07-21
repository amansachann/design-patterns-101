package com.codewithaman.CreationalPatterns.SingletonPattern.WithSingletonPattern;

// Enum-based singleton
// Recommended by Joshua Bloch
public enum EnumBasedSingleton {
    INSTANCE;

    public void doSomething() {
        System.out.println("Do something");
    }
}
