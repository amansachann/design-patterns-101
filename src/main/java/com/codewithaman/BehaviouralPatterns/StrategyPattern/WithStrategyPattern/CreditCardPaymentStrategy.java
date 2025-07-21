package com.codewithaman.BehaviouralPatterns.StrategyPattern.WithStrategyPattern;

public class CreditCardPaymentStrategy implements PaymentStrategy{
    @Override
    public void makePayment(double amount) {
        System.out.println("Credit card payment of " + amount + " is successful!");
    }
}
