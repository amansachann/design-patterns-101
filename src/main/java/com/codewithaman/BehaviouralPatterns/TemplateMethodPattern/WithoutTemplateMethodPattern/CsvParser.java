package com.codewithaman.BehaviouralPatterns.TemplateMethodPattern.WithoutTemplateMethodPattern;

public class CsvParser {

    public void parse() {
        openFile();
        System.out.println( "Parsing CSV file...");
        closeFile();
    }

    private void openFile() {
        System.out.println("Opening CSV file...");
    }

    private void closeFile() {
        System.out.println("Closing CSV file...");
    }
}
