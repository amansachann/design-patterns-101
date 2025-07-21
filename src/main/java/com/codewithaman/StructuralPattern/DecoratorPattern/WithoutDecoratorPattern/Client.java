package com.codewithaman.StructuralPattern.DecoratorPattern.WithoutDecoratorPattern;

public class Client {
    public static void main(String[] args) {
        Pizza pizza = new CheeseMushroomPizza();
        System.out.println(pizza.getDescription() + " costs " + pizza.getCost());
    }
}
