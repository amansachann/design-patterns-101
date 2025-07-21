package com.codewithaman.CreationalPatterns.FactoryPattern.WithFactoryPattern;

public class Car implements Transport {
    @Override
    public void deliver() {
        System.out.println( "Delivering the package in a car");
    }
}
