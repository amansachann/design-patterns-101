package com.codewithaman.BehaviouralPatterns.StatePattern.WithStatePattern;

public class Car implements TransportationMode{
    @Override
    public void calculateETA() {
        System.out.println("ETA: 5 mins");
    }

    @Override
    public void getDirections() {
        System.out.println( "Get on the highway to the destination");
    }
}
