package com.codewithaman.StructuralPattern.FacadePattern.WithFacadePattern;

public class ApiGateway {
    private OrderService orderService;
    private PaymentService paymentService;
    private UserService userService;

    public ApiGateway() {
        this.orderService = new OrderService();
        this.paymentService = new PaymentService();
        this.userService = new UserService();
    }

    public String getOrderDetails(String orderId) {
        return orderService.getOrderDetails(orderId);
    }

    public String processPayment(String amount) {
        return paymentService.processPayment(amount);
    }

    public String getUserDetails(String userId) {
        return userService.getUserDetails(userId);
    }

    public String getFullDetails(String orderId, String userId, String amount) {
        return getOrderDetails(orderId) + "\n" + getUserDetails(userId) + "\n" + processPayment(amount);
    }
}
