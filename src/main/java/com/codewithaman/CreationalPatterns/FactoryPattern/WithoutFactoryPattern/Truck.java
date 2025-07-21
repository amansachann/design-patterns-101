package com.codewithaman.CreationalPatterns.FactoryPattern.WithoutFactoryPattern;

public class Truck implements Transport{
    @Override
    public void deliver() {
        System.out.println( "Delivering the package in a truck");
    }
}
