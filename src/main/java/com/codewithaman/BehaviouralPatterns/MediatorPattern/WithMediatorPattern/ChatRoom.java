package com.codewithaman.BehaviouralPatterns.MediatorPattern.WithMediatorPattern;

import java.util.ArrayList;
import java.util.List;

public class ChatRoom implements ChatMediator{

    private List<User> users;

    public ChatRoom() {
        this.users = new ArrayList<>();
    }

    @Override
    public void sendMessage(String message, User sender) {
        for(User u : users) {
            if(u!=sender) {
                sender.sendMessage(message, u);
            }
        }
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }
}
