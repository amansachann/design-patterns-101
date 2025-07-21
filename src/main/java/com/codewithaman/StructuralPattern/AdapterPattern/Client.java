package com.codewithaman.StructuralPattern.AdapterPattern;

public class Client {
    public static void main(String[] args) {
        NotificationService notificationService = new EmailNotificationService();
        notificationService.send(
                "codewithaman@gmail.com",
                "This is meant for teaching purpose",
                "If you are reading this, then you are awesome. If you are not, then you are not awesome.");
        NotificationService newNotificationService = new SendGridAdapter();
        newNotificationService.send(
                "aman@gmail.com",
                "This is mail from sendgrid",
                "Please appreciate if you've reached till here."
        );
    }
}
