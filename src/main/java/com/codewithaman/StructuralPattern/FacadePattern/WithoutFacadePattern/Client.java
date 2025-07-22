package com.codewithaman.StructuralPattern.FacadePattern.WithoutFacadePattern;

public class Client {
    public static void main(String[] args) {
        // Client code for interacting with different services directly
        OrderService orderService = new OrderService();
        PaymentService paymentService = new PaymentService();
        UserService userService = new UserService();

        // Task
        System.out.println(userService.getUserDetails("123"));
        System.out.println(orderService.getOrderDetails("OA456"));
        System.out.println(paymentService.processPayment("1000"));
    }
}
