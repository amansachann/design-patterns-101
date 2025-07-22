package com.codewithaman.BehaviouralPatterns.ChainOfResponsibility.UsingBothTemplateMethodAndCOR;

abstract class MoneyHandler {
    protected MoneyHandler nextHandler;
    protected int maxNotes;

    public MoneyHandler(int maxNotes) {
        this.maxNotes = maxNotes;
    }

    public void setNextHandler(MoneyHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void dispense(int amount) {
        int noteValue = getNoteValue();
        int notesNeeded = amount / noteValue;

        if(notesNeeded > maxNotes) {
            notesNeeded = maxNotes;
            maxNotes = 0;
        } else {
            maxNotes -= notesNeeded;
        }

        if(notesNeeded > 0) {
            System.out.println("Dispensing " + notesNeeded + " notes of " + noteValue);
        }
        int remainingAmount = amount % noteValue;
        if(remainingAmount > 0) {
            if(nextHandler != null) {
                nextHandler.dispense(remainingAmount);
            } else {
                System.out.println( "Remaining amount of " + remainingAmount + " cannot be dispensed due to insufficient funds in ATM.");
            }
        }
    }

    public abstract int getNoteValue();
}
