package com.codewithaman.BehaviouralPatterns.StrategyPattern.WithoutStrategyPattern;

public class Client {

    public static void main(String[] args) {
        PaymentService paymentService = new PaymentService();
        paymentService.makePayment("credit", 1000);
        paymentService.makePayment("debit", 1000);
        paymentService.makePayment("netbanking", 1000);
        paymentService.makePayment("upi", 1000);
        paymentService.makePayment("cash", 1000);
    }
}
