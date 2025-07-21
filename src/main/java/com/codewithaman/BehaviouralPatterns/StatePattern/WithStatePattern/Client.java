package com.codewithaman.BehaviouralPatterns.StatePattern.WithStatePattern;

public class Client {
    public static void main(String[] args) {
        DirectionService directionService = new DirectionService(new Walking());
        directionService.setTransportationMode(new Car());
        directionService.getEta();
        directionService.getDirections();
    }
}
