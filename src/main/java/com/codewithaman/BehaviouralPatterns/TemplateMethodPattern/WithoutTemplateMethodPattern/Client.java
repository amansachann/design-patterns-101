package com.codewithaman.BehaviouralPatterns.TemplateMethodPattern.WithoutTemplateMethodPattern;

public class Client {
    public static void main(String[] args) {
        CsvParser csvParser = new CsvParser();
        csvParser.parse();
        JsonParser jsonParser = new JsonParser();
        jsonParser.parse();
    }
}
