package com.codewithaman.BehaviouralPatterns.TemplateMethodPattern.WithTemplateMethodPattern;

public class CsvParser extends DataParser{
    @Override
    protected void parseData() {
        System.out.println( "Parsing CSV data...");
    }
}
