package com.codewithaman.StructuralPattern.AdapterPattern;

public class SendGridEmailService {

    public void sendEmail(String recipient, String title, String content) {
        System.out.println("Sending email to: " + recipient);
        System.out.println("Title: " + title);
        System.out.println("Content: " + content);
    }
}
