package com.codewithaman.BehaviouralPatterns.StrategyPattern.WithStrategyPattern;

public class DebitCardPaymentStrategy implements PaymentStrategy{
    @Override
    public void makePayment(double amount) {
        System.out.println("Debit card payment of " + amount + " is successful!");
    }
}
