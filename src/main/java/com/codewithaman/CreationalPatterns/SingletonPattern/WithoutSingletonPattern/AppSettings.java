package com.codewithaman.CreationalPatterns.SingletonPattern.WithoutSingletonPattern;

public class AppSettings {

    private String databaseUrl;
    private String apiKey;

    public AppSettings() {
        this.databaseUrl = "localhost:3306/mydb";
        this.apiKey = "ABCDE-12345";
    }

    public String getDatabaseUrl() {
        return databaseUrl;
    }

    public String getApiKey() {
        return apiKey;
    }
}
