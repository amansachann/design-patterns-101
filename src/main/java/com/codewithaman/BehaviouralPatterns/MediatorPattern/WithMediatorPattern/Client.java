package com.codewithaman.BehaviouralPatterns.MediatorPattern.WithMediatorPattern;

public class Client {

    public static void main(String[] args) {
        // Create users
        User aman = new User("Aman");
        User neha = new User("Neha");
        User akash = new User("Aakash");
        User shubham = new User("Shubham");
        User rahul = new User("Rahul");

        // Add all of them to chat room
        ChatMediator chatRoom = new ChatRoom();
        chatRoom.addUser(aman);
        chatRoom.addUser(neha);
        chatRoom.addUser(akash);
        chatRoom.addUser(shubham);
        chatRoom.addUser(rahul);

        // Send message
        rahul.sendMessageToAll("Hello Everyone!", chatRoom);
    }
}
