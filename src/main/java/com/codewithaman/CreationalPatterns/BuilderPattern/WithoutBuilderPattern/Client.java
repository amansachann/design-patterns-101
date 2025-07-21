package com.codewithaman.CreationalPatterns.BuilderPattern.WithoutBuilderPattern;

public class Client {
    public static void main(String[] args) {
        // Too Many constructors -- Constructor explosion
        // N arguments -- 2^N possible constructors
        // Even all of them are not valid
        // Code becomes difficult to read and maintain
        Burger burger = new Burger(
                "Sesame Bun",
                "Chicken Patty",
                false,
                false);
        System.out.println(burger);
    }
}
