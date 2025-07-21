package com.codewithaman.CreationalPatterns.FactoryPattern.WithFactoryPattern;

public class TransportFactory {

    // Create a static method to retrieve objects of the specific class
    public static Transport getTransport(String transportType) {
        switch(transportType) {
            case "bike":
                return new Bike();
            case "car":
                return new Car();
            case "truck":
                return new Truck();
            case "bus":
                return new Bus();
            default:
                throw new IllegalArgumentException("Invalid transport type");
        }
    }
}
