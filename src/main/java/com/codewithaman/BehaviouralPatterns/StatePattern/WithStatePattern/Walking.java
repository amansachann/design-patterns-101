package com.codewithaman.BehaviouralPatterns.StatePattern.WithStatePattern;

public class Walking implements TransportationMode{
    @Override
    public void calculateETA() {
        System.out.println( "ETA: 10 mins");
    }

    @Override
    public void getDirections() {
        System.out.println( "Walk 400m north to reach the destination");
    }
}
