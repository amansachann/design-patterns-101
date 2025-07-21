package com.codewithaman.BehaviouralPatterns.MediatorPattern.WithMediatorPattern;

public interface ChatMediator {
    void sendMessage(String message, User user);
    void addUser(User user);
}
