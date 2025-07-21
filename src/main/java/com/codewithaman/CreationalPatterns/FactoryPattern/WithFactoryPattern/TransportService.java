package com.codewithaman.CreationalPatterns.FactoryPattern.WithFactoryPattern;

public class TransportService {
    public static void main(String[] args) {
        // value passed to the factory method can be a runtime value
        Transport vehicle = TransportFactory.getTransport("bike");
        vehicle.deliver();
    }
}
