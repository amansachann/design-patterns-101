package com.codewithaman.StructuralPattern.DecoratorPattern.WithDecoratorPattern;

public class MushroomDecorator extends PizzaDecorator{
    public MushroomDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Mushroom";
    }

    @Override
    public double getCost() {
        return super.getCost() + 20;
    }
}
