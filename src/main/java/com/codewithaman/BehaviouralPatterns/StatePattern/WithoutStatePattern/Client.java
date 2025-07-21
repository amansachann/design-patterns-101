package com.codewithaman.BehaviouralPatterns.StatePattern.WithoutStatePattern;

public class Client {
    public static void main(String[] args) {
        DirectionService directionService = new DirectionService(TransportationMode.WALKING);

        directionService.calculateETA();
        directionService.getDirections();

    }
}
