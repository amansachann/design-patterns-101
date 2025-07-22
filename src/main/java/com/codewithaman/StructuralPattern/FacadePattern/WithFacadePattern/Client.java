package com.codewithaman.StructuralPattern.FacadePattern.WithFacadePattern;

public class Client {
    public static void main(String[] args) {
        // Client code for interacting with API Gateway (Facade)
        ApiGateway apiGateway = new ApiGateway();

        // Task
        System.out.println(apiGateway.getFullDetails("OA123", "124", "1299"));
    }
}
