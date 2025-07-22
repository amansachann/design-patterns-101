package com.codewithaman.BehaviouralPatterns.ChainOfResponsibility;

public class ThousandHandler extends MoneyHandler{

    private static final int THOUSAND = 1000;
    private int maxNotes;

    public ThousandHandler(int maxNotes) {
        this.maxNotes = maxNotes;
    }

    @Override
    public void dispense(int amount) {
        int notesNeeded = amount / THOUSAND;
        if(notesNeeded > maxNotes) {
            notesNeeded = maxNotes;
            maxNotes = 0;
        } else {
            maxNotes -= notesNeeded;
        }

        if(notesNeeded > 0) {
            System.out.println("Dispensing " + notesNeeded + " notes of 1000");
        }
        int remainingAmount = amount % THOUSAND;
        if(remainingAmount > 0) {
            if(nextHandler != null) {
                nextHandler.dispense(remainingAmount);
            } else {
                System.out.println( "Remaining amount of " + remainingAmount + " cannot be dispensed due to insufficient funds in ATM.");
            }
        }
    }
}
