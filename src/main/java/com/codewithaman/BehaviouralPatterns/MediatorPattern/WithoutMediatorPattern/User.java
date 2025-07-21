package com.codewithaman.BehaviouralPatterns.MediatorPattern.WithoutMediatorPattern;

public class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sendMessage(String message, User recipient) {
        System.out.println(name + " sent message to " +  recipient.getName() + ": " + message);
    }
}
