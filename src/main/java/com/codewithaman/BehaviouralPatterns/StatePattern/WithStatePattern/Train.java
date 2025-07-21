package com.codewithaman.BehaviouralPatterns.StatePattern.WithStatePattern;

public class Train implements TransportationMode{
    @Override
    public void calculateETA() {
        System.out.println( "ETA: 2 mins");
    }

    @Override
    public void getDirections() {
        System.out.println("Get the next train to downtown");
    }
}
