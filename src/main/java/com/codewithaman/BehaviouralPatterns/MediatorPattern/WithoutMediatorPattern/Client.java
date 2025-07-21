package com.codewithaman.BehaviouralPatterns.MediatorPattern.WithoutMediatorPattern;

public class Client {

    public static void main(String[] args) {
        // Create Users
        User aman = new User("Aman");
        User neha = new User("Neha");
        User akash = new User("Aakash");
        User shubham = new User("Shubham");
        User rahul = new User("Rahul");

        // Rahul wants to send a message to all others
        String message = "Hello Everyone!";
        rahul.sendMessage(message, aman);
        rahul.sendMessage(message, neha);
        rahul.sendMessage(message, akash);
        rahul.sendMessage(message, shubham);
    }
}
