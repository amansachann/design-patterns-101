package com.codewithaman.CreationalPatterns.SingletonPattern.WithSingletonPattern;

public class Client {
    public static void main(String[] args) {
        // Lazy Initialization
        AppSettings appSettings = AppSettings.getInstance();
        AppSettings appSettingsCopy = AppSettings.getInstance();

        System.out.println(appSettings == appSettingsCopy);

        // Thread Safe Singleton
        ThreadSafeSingleton threadSafeSingleton = ThreadSafeSingleton.getInstance();
        ThreadSafeSingleton threadSafeSingletonCopy = ThreadSafeSingleton.getInstance();
        System.out.println(threadSafeSingleton == threadSafeSingletonCopy);

        // Bill Pough Singleton
        BillPoughSingleton billPoughSingleton = BillPoughSingleton.getInstance();
        BillPoughSingleton billPoughSingletonCopy = BillPoughSingleton.getInstance();
        System.out.println(billPoughSingleton == billPoughSingletonCopy);

        // Enum-based singleton
        EnumBasedSingleton enumBasedSingleton = EnumBasedSingleton.INSTANCE;
        EnumBasedSingleton enumBasedSingletonCopy = EnumBasedSingleton.INSTANCE;
        System.out.println(enumBasedSingleton == enumBasedSingletonCopy);
    }
}
