package com.codewithaman.BehaviouralPatterns.ChainOfResponsibility.UsingBothTemplateMethodAndCOR;

public class FiveHundredHandler extends MoneyHandler{
    @Override
    public int getNoteValue() {
        return 500;
    }

    public FiveHundredHandler(int maxNotes) {
        super(maxNotes);
    }
}
