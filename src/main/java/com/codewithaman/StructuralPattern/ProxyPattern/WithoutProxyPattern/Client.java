package com.codewithaman.StructuralPattern.ProxyPattern.WithoutProxyPattern;

public class Client {
    public static void main(String[] args) {
        Image img1 = new RealImage("dog.jpg");
        Image img2 = new RealImage("cat.jpg");

        // Here the real image is loaded every time we create it,
        // which can be inefficient if the image is not always required
        img1.display();
        img1.display();
    }
}
