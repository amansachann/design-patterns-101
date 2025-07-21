package com.codewithaman.BehaviouralPatterns.StrategyPattern.WithStrategyPattern;

public class PaymentService {
    PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void makePayment(double amount) {
        paymentStrategy.makePayment(amount);
    }
}
