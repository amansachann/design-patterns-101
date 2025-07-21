package com.codewithaman.BehaviouralPatterns.StatePattern.WithStatePattern;

public class Cycling implements TransportationMode{
    @Override
    public void calculateETA() {
        System.out.println( "ETA: 7 mins");
    }

    @Override
    public void getDirections() {
        System.out.println("Get on the bike and head north to the destination");
    }
}
