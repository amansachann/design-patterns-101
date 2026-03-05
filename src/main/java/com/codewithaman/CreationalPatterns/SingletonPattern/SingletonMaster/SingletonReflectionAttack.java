package com.codewithaman.CreationalPatterns.SingletonPattern.SingletonMaster;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingletonReflectionAttack {
    public static void main(String[] args) {
        Browser instance1 = Browser.getInstance();
        Browser instance2 = null;

        try {
            Constructor<Browser> browserConstructor = Browser.class.getDeclaredConstructor();
            browserConstructor.setAccessible(true);
            instance2 = browserConstructor.newInstance();
            System.out.println("Instance 1 hashcode: " + instance1.hashCode() + "\nInstance 2 hashcode: " + instance2.hashCode() + "");
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
