package com.codewithaman.BehaviouralPatterns.ObserverPattern;

class DisplayDevice {
    public void showTemperature(float temperature) {
        System.out.println( "Current temperature: " + temperature + " C");
    }
}

class WeatherStation {
    private float temperature;
    private DisplayDevice displayDeviceA;
    private DisplayDevice displayDeviceB;
    public WeatherStation(DisplayDevice displayDeviceA, DisplayDevice displayDeviceB) {
        this.displayDeviceA = displayDeviceA;
        this.displayDeviceB = displayDeviceB;
    }
    public void setTemperature(float temperature) {
        this.temperature = temperature;
        updateDisplayDevices();
    }

    public void updateDisplayDevices() {
        displayDeviceA.showTemperature(temperature);
        displayDeviceB.showTemperature(temperature);
    }
}

public class WithoutObserverPattern {
    public static void main(String[] args) {
        DisplayDevice displayDeviceA = new DisplayDevice();
        DisplayDevice displayDeviceB = new DisplayDevice();
        WeatherStation weatherStation = new WeatherStation(displayDeviceA, displayDeviceB);
        weatherStation.setTemperature(20);
    }
}
