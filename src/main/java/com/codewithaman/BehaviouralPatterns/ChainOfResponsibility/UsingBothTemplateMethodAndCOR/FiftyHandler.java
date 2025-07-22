package com.codewithaman.BehaviouralPatterns.ChainOfResponsibility.UsingBothTemplateMethodAndCOR;

public class FiftyHandler extends MoneyHandler{
    @Override
    public int getNoteValue() {
        return 50;
    }

    public FiftyHandler(int maxNotes) {
        super(maxNotes);
    }
}
