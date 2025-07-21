package com.codewithaman.BehaviouralPatterns.StrategyPattern.WithoutStrategyPattern;

public class PaymentService {

    public void makePayment(String paymentType, double amount) {
        if(paymentType.equalsIgnoreCase("credit")) {
            System.out.println("Credit card payment of " + amount + " is successful!");
        } else if(paymentType.equalsIgnoreCase("debit")) {
            System.out.println("Debit card payment of " + amount + " is successful!");
        } else if(paymentType.equalsIgnoreCase("netbanking")) {
            System.out.println("Net banking payment of " + amount + " is successful!");
        } else if(paymentType.equalsIgnoreCase("upi")) {
            System.out.println("UPI payment of " + amount + " is successful!");
        }  else {
            System.out.println("Payment type not supported!");
        }
    }
}
