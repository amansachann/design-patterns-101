package com.codewithaman.CreationalPatterns.SingletonPattern.WithoutSingletonPattern;

public class Client {
    public static void main(String[] args) {
        AppSettings appSettings = new AppSettings();
        AppSettings appSettingsCopy = new AppSettings();

        // Problem: More memory, Inconsistencies
        // Therefore, singleton pattern so that only one instance of this class is created
        System.out.println(appSettings == appSettingsCopy);

    }
}
