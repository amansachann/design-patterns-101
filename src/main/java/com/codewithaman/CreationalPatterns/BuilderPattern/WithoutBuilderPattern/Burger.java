package com.codewithaman.CreationalPatterns.BuilderPattern.WithoutBuilderPattern;

public class Burger {
    private String bun;
    private String patty;
    private boolean cheese;
    private boolean tomato;

    // Constructor
    public Burger(String bun, String patty, boolean cheese, boolean tomato) {
        this.bun = bun;
        this.patty = patty;
        this.cheese = cheese;
        this.tomato = tomato;
    }

    @Override
    public String toString() {
        return "Burger{" +
                "bun='" + bun + '\'' +
                ", patty='" + patty + '\'' +
                ", cheese=" + cheese +
                ", tomato=" + tomato +
                '}';
    }
}
