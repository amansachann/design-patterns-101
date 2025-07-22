package com.codewithaman.BehaviouralPatterns.ChainOfResponsibility.UsingBothTemplateMethodAndCOR;

public class ThousandHandler extends MoneyHandler{

    public ThousandHandler(int maxNotes) {
        super(maxNotes);
    }

    @Override
    public int getNoteValue() {
        return 1000;
    }
}
