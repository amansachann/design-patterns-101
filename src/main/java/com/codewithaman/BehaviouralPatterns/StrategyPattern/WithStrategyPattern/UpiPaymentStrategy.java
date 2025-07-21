package com.codewithaman.BehaviouralPatterns.StrategyPattern.WithStrategyPattern;

public class UpiPaymentStrategy implements PaymentStrategy{
    @Override
    public void makePayment(double amount) {
        System.out.println("UPI payment of " + amount + " is successful!");
    }
}
