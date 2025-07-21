package com.codewithaman.StructuralPattern.ProxyPattern.WithProxyPattern;

public class ProxyImage implements Image{

    private String fileName;

    private RealImage realImage; // proxy reference to the real image

    public ProxyImage(String fileName) {
        this.fileName = fileName;
        this.realImage = null;
    }

    @Override
    public void display() {
        if(realImage == null) {
            realImage = new RealImage(fileName); // Image is loaded and cached
        }
        realImage.display();
    }
}
