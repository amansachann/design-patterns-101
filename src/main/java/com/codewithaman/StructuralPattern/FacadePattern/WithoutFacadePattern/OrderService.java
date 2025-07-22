package com.codewithaman.StructuralPattern.FacadePattern.WithoutFacadePattern;

// Microservice for order management
public class OrderService {

    public String getOrderDetails(String orderId) {
        // Simulate fetching order details
        return "Order details for orderId: " + orderId;
    }
}
