package com.codewithaman.CreationalPatterns.BuilderPattern.WithBuilderPattern;

public class BurgerBuilder {
    private String bun;
    private String patty;
    private boolean cheese;
    private boolean lettuce;

    public BurgerBuilder setBun(String bun) {
        this.bun = bun;
        return this;
    }

    public BurgerBuilder setPatty(String patty) {
        this.patty = patty;
        return this;
    }

    public BurgerBuilder setCheese(boolean cheese) {
        this.cheese = cheese;
        return this;
    }

    public BurgerBuilder setLettuce(boolean lettuce) {
        this.lettuce = lettuce;
        return this;
    }

    public Burger build() {
        return new Burger(bun, patty, cheese, lettuce);
    }

}
