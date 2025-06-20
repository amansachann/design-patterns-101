package com.codewithaman.BehaviouralPatterns.ObserverPattern;


// Observer Interface
interface Observer {
    String getName();
    void update(float temperature);
}

// Subject Interface
interface Subject {
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}

class DisplayDeviceIn implements Observer {

    private final String name;

    public DisplayDeviceIn() {
        this.name = "LCD Display Device";
    }

    public String getName() {
        return name;
    }

    @Override
    public void update(float temperature) {
        System.out.println( "Current temperature on display: " + temperature + " C");
    }
}

class MobileDeviceIn implements Observer {
    private final String name;

    public MobileDeviceIn() {
        this.name = "Samsung Mobile Device";
    }

    public String getName() {
        return name;
    }

    @Override
    public void update(float temperature) {
        System.out.println( "Current temperature on mobile device: " + temperature + " C");
    }
}

class WeatherStationIn implements Subject {
    private float temperature;
    private final java.util.List<Observer> observers;

    public WeatherStationIn() {
        observers = new java.util.ArrayList<>();
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
        notifyObservers();
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
        System.out.println(o.getName() + " added as observer.");
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
        System.out.println(o.getName() + " removed as observer.");
    }

    @Override
    public void notifyObservers() {
        for(Observer observer : observers) {
            observer.update(temperature);
        }
    }
}

public class ObserverPatternDemo {

    public static void main(String[] args) {
        WeatherStationIn weatherStation = new WeatherStationIn();
        DisplayDeviceIn displayDevice = new DisplayDeviceIn();
        MobileDeviceIn mobileDevice = new MobileDeviceIn();
        weatherStation.addObserver(displayDevice);
        weatherStation.addObserver(mobileDevice);
        weatherStation.setTemperature(20);
        weatherStation.removeObserver(displayDevice);
        weatherStation.setTemperature(30);
    }
}
