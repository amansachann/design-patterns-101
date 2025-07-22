package com.codewithaman.StructuralPattern.FlyweightPattern.WithoutFlyweightPattern;

public class Game {
    public static void main(String[] args) {
        // 5 Red bullet objects
        for (int i = 0; i < 5; i++) {
            Bullet bullet = new Bullet("Red", i*10, i*12, 10);
        }

        // 5 Yellow bullet objects
        for (int i = 0; i < 5; i++) {
            Bullet bullet = new Bullet("Yellow", i*30, i*42, 10);
        }

        // Problems:
        // Memory Overhead: Every bullet stores redundant data like color, image, etc
        // Performance: Slow performance when many bullets are created
    }
}
