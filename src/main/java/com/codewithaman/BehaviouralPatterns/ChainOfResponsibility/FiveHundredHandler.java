package com.codewithaman.BehaviouralPatterns.ChainOfResponsibility;

public class FiveHundredHandler extends MoneyHandler {

    private static final int FIVE_HUNDRED = 500;
    private int maxNotes;

    public FiveHundredHandler(int maxNotes) {
        this.maxNotes = maxNotes;
    }

    @Override
    public void dispense(int amount) {
        int notesNeeded = amount / FIVE_HUNDRED;
        if(notesNeeded > maxNotes) {
            notesNeeded = maxNotes;
            maxNotes = 0;
        } else {
            maxNotes -= notesNeeded;
        }

        if(notesNeeded > 0) {
            System.out.println("Dispensing " + notesNeeded + " notes of 500");
        }
        int remainingAmount = amount % FIVE_HUNDRED;
        if(remainingAmount > 0) {
            if(nextHandler != null) {
                nextHandler.dispense(remainingAmount);
            } else {
                System.out.println( "Remaining amount of " + remainingAmount + " cannot be dispensed due to insufficient funds in ATM.");
            }
        }
    }
}
