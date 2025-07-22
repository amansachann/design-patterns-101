package com.codewithaman.StructuralPattern.FlyweightPattern.WithoutFlyweightPattern;

public class Bullet {

    private String color;       // Intrinsic property shared by all bullets

    private int x, y;           // Extrinsic property unique for each bullet
    private int velocity;

    public Bullet(String color, int x, int y, int velocity) {
        this.color = color;     // Same for all bullets
        this.x = x;
        this.y = y;
        this.velocity = velocity;
        System.out.println("Created " + color + " bullet object at (" + x + "," + y + ") moving with velocity " + velocity + ".");
    }

    public void display() {
        System.out.println(color + " bullet at (" + x + "," + y + ") moving with velocity " + velocity + ".");
    }
}
