package com.codewithaman.CreationalPatterns.SingletonPattern.SingletonMaster;

import java.io.*;

public class BrowserReadResolve {

    public static void main(String[] args) {
        try {
            Browser instance1 = Browser.getInstance();

            // Serialize the browser instance
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("browser.json"));
            out.writeObject(instance1);
            out.close();

            // Deserialize the browser instance
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("browser.json"));
            Browser instance2 = (Browser) in.readObject();
            in.close();

            ObjectInputStream in2 = new ObjectInputStream(new FileInputStream("browser.json"));
            Browser instance3 = (Browser) in2.readObject();
            in2.close();

            System.out.println("Instance 1 hash code: " + instance1.hashCode());
            System.out.println("Instance 2 hash code: " + instance2.hashCode());
            System.out.println("Instance 3 hash code: " + instance3.hashCode());
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
