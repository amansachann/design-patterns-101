package com.codewithaman.StructuralPattern.AdapterPattern;

public class SendGridAdapter implements NotificationService{
    private final SendGridEmailService sendGridEmailService;
    public SendGridAdapter() {
        sendGridEmailService = new SendGridEmailService();
    }

    // Adapter Method --> Convert params and calls to Sendgrid's method
    @Override
    public void send(String to, String subject, String body) {
        sendGridEmailService.sendEmail(to, subject, body);
    }

}
