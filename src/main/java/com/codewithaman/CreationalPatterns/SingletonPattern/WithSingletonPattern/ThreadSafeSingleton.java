package com.codewithaman.CreationalPatterns.SingletonPattern.WithSingletonPattern;

public class ThreadSafeSingleton {
    // Step-1: Create a private static volatile instance of class
    private static volatile ThreadSafeSingleton instance;

    // Step-2: Make the constructor private
    private ThreadSafeSingleton() {}

    // Step-3: Create a method to get the instance of the class
    // There are two null checks to avoid two object creations
    // in case of concurrent threads
    public static ThreadSafeSingleton getInstance() {
        if (instance == null) {
            synchronized (ThreadSafeSingleton.class) {
                if (instance == null) {
                    instance = new ThreadSafeSingleton();
                }
            }
        }
        return instance;
    }
}
