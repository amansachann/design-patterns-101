package com.codewithaman.BehaviouralPatterns.TemplateMethodPattern.WithTemplateMethodPattern;

public class JsonParser extends DataParser{
    @Override
    protected void parseData() {
        System.out.println( "Parsing JSON data...");
    }
}
