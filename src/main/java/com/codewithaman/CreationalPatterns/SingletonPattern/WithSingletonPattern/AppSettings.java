package com.codewithaman.CreationalPatterns.SingletonPattern.WithSingletonPattern;

public class AppSettings {
    // Lazy Initialization -- Not thread safe
    // Step-1: Create a private static instance of a class
    private static AppSettings instance;

    private String databaseUrl;
    private String apiKey;


    // Step-2: Make the constructor private to prevent direct object creation
    private AppSettings() {
        this.databaseUrl = "localhost:3306/mydb";
        this.apiKey = "ABCDE-12345";

    }

    // Step-3: Public static method to get instance of this class
    public static AppSettings getInstance() {
        if (instance == null) {
            instance = new AppSettings();
        }
        return instance;
    }

    public String getDatabaseUrl() {
        return databaseUrl;
    }

    public String getApiKey() {
        return apiKey;
    }
}
