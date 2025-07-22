package com.codewithaman.BehaviouralPatterns.ChainOfResponsibility;

public class Client {
    public static void main(String[] args) {
        MoneyHandler thoudandHandler = new ThousandHandler(5000);
        MoneyHandler fiveHundredHandler = new FiveHundredHandler(1000);
        MoneyHandler hundredHandler = new HundredHandler(5000);

        thoudandHandler.setNextHandler(fiveHundredHandler);
        fiveHundredHandler.setNextHandler(hundredHandler);

        thoudandHandler.dispense(10700);
    }
}
