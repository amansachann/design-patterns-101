package com.codewithaman.CreationalPatterns.FactoryPattern.WithoutFactoryPattern;

public class TransportService {
    public static void main(String[] args) {
        Transport car = new Car();
        Transport bike = new Bike();
        Transport truck = new Truck();
        car.deliver();
        bike.deliver();
        truck.deliver();

        // New transport added
        Transport bus = new Bus();
        bus.deliver();
    }
}
