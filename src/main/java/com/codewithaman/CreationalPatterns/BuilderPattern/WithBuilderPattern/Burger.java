package com.codewithaman.CreationalPatterns.BuilderPattern.WithBuilderPattern;

public class Burger {
    private String bun;
    private String patty;
    private boolean cheese;
    private boolean lettuce;

    public Burger(String bun, String patty, boolean cheese, boolean lettuce) {
        this.bun = bun;
        this.patty = patty;
        this.cheese = cheese;
        this.lettuce = lettuce;
    }

    @Override
    public String toString() {
        return "Burger{" +
                "bun='" + bun + '\'' +
                ", patty='" + patty + '\'' +
                ", cheese=" + cheese +
                ", lettuce=" + lettuce +
                '}';
    }
}
