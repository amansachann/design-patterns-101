package com.codewithaman.BehaviouralPatterns.ChainOfResponsibility.UsingBothTemplateMethodAndCOR;

public class Client {
    public static void main(String[] args) {
        MoneyHandler thoudandHandler = new ThousandHandler(5000);
        MoneyHandler fiveHundredHandler = new FiveHundredHandler(1000);
        MoneyHandler hundredHandler = new HundredHandler(5000);
        MoneyHandler fiftyHandler = new FiftyHandler(1000);

        thoudandHandler.setNextHandler(fiveHundredHandler);
        fiveHundredHandler.setNextHandler(hundredHandler);
        hundredHandler.setNextHandler(fiftyHandler);

        thoudandHandler.dispense(10760);
    }
}
