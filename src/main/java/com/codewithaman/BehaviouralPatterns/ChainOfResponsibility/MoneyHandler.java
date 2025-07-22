package com.codewithaman.BehaviouralPatterns.ChainOfResponsibility;

abstract class MoneyHandler {

    protected MoneyHandler nextHandler;

    public void setNextHandler(MoneyHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract void dispense(int amount);
}
