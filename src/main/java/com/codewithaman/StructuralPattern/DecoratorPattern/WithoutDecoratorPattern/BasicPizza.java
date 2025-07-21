package com.codewithaman.StructuralPattern.DecoratorPattern.WithoutDecoratorPattern;

public class BasicPizza implements Pizza{
    @Override
    public String getDescription() {
        return "Basic Pizza";
    }

    @Override
    public double getCost() {
        return 80;
    }
}
