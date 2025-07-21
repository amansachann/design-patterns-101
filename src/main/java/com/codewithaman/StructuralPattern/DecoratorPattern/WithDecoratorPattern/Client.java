package com.codewithaman.StructuralPattern.DecoratorPattern.WithDecoratorPattern;

public class Client {
    public static void main(String[] args) {
        Pizza pizza = new BasicPizza();
        System.out.println(pizza.getDescription() + " costs " + pizza.getCost());
        pizza = new CheeseDecorator(pizza);
        System.out.println(pizza.getDescription() + " costs " + pizza.getCost());
        pizza = new MushroomDecorator(pizza);
        System.out.println(pizza.getDescription() + " costs " + pizza.getCost());

        Pizza pizza2 = new MushroomDecorator(new CheeseDecorator(new OliveDecorator(new BasicPizza())));
        System.out.println(pizza2.getDescription() + " costs " + pizza2.getCost());
    }
}
