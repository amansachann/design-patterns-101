package com.codewithaman.BehaviouralPatterns.ChainOfResponsibility;

public class HundredHandler extends MoneyHandler{

    private static final int HUNDRED = 100;
    private int maxNotes;

    public HundredHandler(int maxNotes) {
        this.maxNotes = maxNotes;
    }

    @Override
    public void dispense(int amount) {
        int notesNeeded = amount / HUNDRED;
        if(notesNeeded > maxNotes) {
            notesNeeded = maxNotes;
            maxNotes = 0;
        } else {
            maxNotes -= notesNeeded;
        }

        if(notesNeeded > 0) {
            System.out.println("Dispensing " + notesNeeded + " notes of 100");
        }
        int remainingAmount = amount % HUNDRED;
        if(remainingAmount > 0) {
            if(nextHandler != null) {
                nextHandler.dispense(remainingAmount);
            } else {
                System.out.println( "Remaining amount of " + remainingAmount + " cannot be dispensed due to insufficient funds in ATM.");
            }
        }
    }
}
