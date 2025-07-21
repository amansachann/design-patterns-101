package com.codewithaman.BehaviouralPatterns.TemplateMethodPattern.WithTemplateMethodPattern;

public class Client {

    public static void main(String[] args) {
        DataParser csvParser = new CsvParser();
        csvParser.parse();
        DataParser jsonParser = new JsonParser();
        jsonParser.parse();
    }
}
