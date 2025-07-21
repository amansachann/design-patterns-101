package com.codewithaman.BehaviouralPatterns.TemplateMethodPattern.WithoutTemplateMethodPattern;

public class JsonParser {

    public void parse() {
        openFile();
        System.out.println( "Parsing JSON file...");
        closeFile();
    }

    private void openFile() {
        System.out.println("Opening JSON file...");
    }

    private void closeFile() {
        System.out.println("Closing JSON file...");
    }
}

