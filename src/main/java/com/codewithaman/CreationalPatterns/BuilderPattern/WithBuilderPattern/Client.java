package com.codewithaman.CreationalPatterns.BuilderPattern.WithBuilderPattern;

public class Client {
    public static void main(String[] args) {
        Burger burger = new BurgerBuilder()
                .setBun("Sesame Bun")
                .setPatty("Chicken Patty")
                .setCheese(true)
                .setLettuce(false)
                .build();
        System.out.println(burger);

        House house = new House.Builder("Concrete", "Wood", "Marble").build();
        System.out.println(house);
    }
}
