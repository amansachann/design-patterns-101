package com.codewithaman.BehaviouralPatterns.StrategyPattern.WithStrategyPattern;

public class Client {
    public static void main(String[] args) {
        PaymentService paymentService = new PaymentService();
        paymentService.setPaymentStrategy(new DebitCardPaymentStrategy());
        paymentService.makePayment(1000);
        paymentService.setPaymentStrategy(new CreditCardPaymentStrategy());
        paymentService.makePayment(1000);
        paymentService.setPaymentStrategy(new NetBankingPaymentStrategy());
        paymentService.makePayment(1000);
        paymentService.setPaymentStrategy(new UpiPaymentStrategy());
        paymentService.makePayment(1000);
    }
}
