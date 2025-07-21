package com.codewithaman.StructuralPattern.ProxyPattern.WithProxyPattern;

public class Client {
    public static void main(String[] args) {
        Image img1 = new ProxyImage("dog.jpg");
        Image img2 = new ProxyImage("cat.jpg");
        // The image is loaded lazily if needed,
        // saving time and resources
        // if the image is never displayed
        img1.display();  // Loaded and cached, then displayed
        img1.display();  // already loaded so directly displayed
    }
}
