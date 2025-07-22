package com.codewithaman.StructuralPattern.FlyweightPattern.WithFlyweightPattern;

public class Bullet {
    private BulletType type;

    private int x, y;
    private int velocity;

    public Bullet(String color, int x, int y, int velocity) {
        this.type = BulletTypeFactory.getBulletType(color);
        this.x = x;
        this.y = y;
        this.velocity = velocity;
        System.out.println("Created " + color + " bullet object at (" + x + "," + y + ") moving with velocity " + velocity + ".");
    }

    public void display() {
        System.out.println(this.type.getColor() + " bullet at (" + x + "," + y + ") moving with velocity " + velocity + ".");
    }
}
