package com.codewithaman.BehaviouralPatterns.ChainOfResponsibility.UsingBothTemplateMethodAndCOR;

public class HundredHandler extends MoneyHandler{
    public HundredHandler(int maxNotes) {
        super(maxNotes);
    }

    @Override
    public int getNoteValue() {
        return 100;
    }
}
