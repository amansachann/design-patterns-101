package com.codewithaman.CreationalPatterns.SingletonPattern.WithSingletonPattern;

public class BillPoughSingleton {
    // Step-1: Create a private constructor
    private BillPoughSingleton() {}

    // Step-2: Create a inner singleton class
    private static class SingletonHelper {
        // Step-3: Create a private static final instance of the parent class
        private static final BillPoughSingleton INSTANCE = new BillPoughSingleton();
    }

    // Step-4: Create a method to get the instance of the class
    public static BillPoughSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }

}
