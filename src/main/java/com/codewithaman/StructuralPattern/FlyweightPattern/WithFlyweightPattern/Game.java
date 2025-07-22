package com.codewithaman.StructuralPattern.FlyweightPattern.WithFlyweightPattern;

public class Game {
    public static void main(String[] args) {
        // 5 red color bullets
        for (int i = 0; i < 5; i++) {
            Bullet bullet = new Bullet("Red", i*10, i*12, 10);
        }
        // 5 yellow color bullets
        for (int i = 0; i < 5; i++) {
            Bullet bullet = new Bullet("Yellow", i*20, i*32, 10);
        }
    }
}
