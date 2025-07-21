package com.codewithaman.BehaviouralPatterns.TemplateMethodPattern.WithTemplateMethodPattern;

// Template class
public abstract class DataParser {
    // Template method which define the steps of the alogorithm
    public void parse() {
        openFile();
        parseData();
        closeFile();
    }
    protected abstract void parseData();
    protected void openFile() {
        System.out.println("Opening file...");
    }
    protected void closeFile() {
        System.out.println("Closing file...");
    }
}
