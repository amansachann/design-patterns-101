package com.codewithaman.BehaviouralPatterns.StrategyPattern.WithStrategyPattern;

public class NetBankingPaymentStrategy implements PaymentStrategy{
    @Override
    public void makePayment(double amount) {
        System.out.println("Net banking payment of " + amount + " is successful!");
    }
}
