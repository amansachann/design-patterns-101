package com.codewithaman.BehaviouralPatterns.StatePattern.WithoutStatePattern;

public class DirectionService {

    private TransportationMode currentMode;

    public DirectionService(TransportationMode mode) {
        this.currentMode = mode;
    }

    public TransportationMode getCurrentMode() {
        return currentMode;
    }

    public void setCurrentMode(TransportationMode currentMode) {
        this.currentMode = currentMode;
    }

    // Calculate the ETA
    public void calculateETA() {
        switch (currentMode) {
            case WALKING:
                System.out.println("ETA: 10 minutes");
                break;
            case CAR:
                System.out.println("ETA: 20 minutes");
                break;
            case CYCLING:
                System.out.println("ETA: 15 minutes");
                break;
            case TRAIN:
                System.out.println("ETA: 30 minutes");
                break;
            default:
                System.out.println("Invalid mode");
                break;
        }
    }

    // Get the directions
    public void getDirections() {
        switch (currentMode) {
            case WALKING:
                System.out.println("Walk to the destination");
                break;
            case CAR:
                System.out.println("Drive to the destination");
                break;
            case CYCLING:
                System.out.println("Cycle to the destination");
                break;
            case TRAIN:
                System.out.println("Train to the destination");
                break;
            default:
                System.out.println("Invalid mode");
                break;
        }
    }
}
