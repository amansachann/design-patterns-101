package com.codewithaman.StructuralPattern.FacadePattern.WithoutFacadePattern;

// Microservice for payment processing
public class PaymentService {
    public String processPayment(String amount) {
        // Simulate payment processing
        return "Payment processed for amount: " + amount;
    }
}
