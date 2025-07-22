package com.codewithaman.StructuralPattern.FlyweightPattern.WithFlyweightPattern;

// Flyweight class
public class BulletType {
    private String color;

    public BulletType(String color) {
        this.color = color;
        System.out.println("\nCreated bullet type " + color + ".\n");
    }

    public String getColor() {
        return color;
    }
}
