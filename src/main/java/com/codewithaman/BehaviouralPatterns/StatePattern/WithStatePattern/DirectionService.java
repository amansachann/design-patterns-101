package com.codewithaman.BehaviouralPatterns.StatePattern.WithStatePattern;

public class DirectionService {
    TransportationMode transportationMode;

    public DirectionService(TransportationMode transportationMode) {
        this.transportationMode = transportationMode;
    }

    public TransportationMode getTransportationMode() {
        return transportationMode;
    }

    public void setTransportationMode(TransportationMode transportationMode) {
        this.transportationMode = transportationMode;
    }

    public void getEta() {
        transportationMode.calculateETA();
    }

    public void getDirections() {
        transportationMode.getDirections();
    }
}
