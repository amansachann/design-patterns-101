package com.codewithaman.StructuralPattern.DecoratorPattern.WithoutDecoratorPattern;

public class CheesePizza extends BasicPizza{
    @Override
    public String getDescription() {
        return super.getDescription() + ", Cheese";
    }

    @Override
    public double getCost() {
        return super.getCost() + 30;
    }
}
