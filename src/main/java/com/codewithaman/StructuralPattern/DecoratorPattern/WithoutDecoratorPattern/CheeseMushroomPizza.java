package com.codewithaman.StructuralPattern.DecoratorPattern.WithoutDecoratorPattern;

public class CheeseMushroomPizza extends CheesePizza{
    @Override
    public String getDescription() {
        return super.getDescription() + ", Mushroom";
    }

    @Override
    public double getCost() {
        return super.getCost() + 20;
    }
}
