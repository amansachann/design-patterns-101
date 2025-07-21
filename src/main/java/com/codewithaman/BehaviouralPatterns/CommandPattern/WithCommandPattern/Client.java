package com.codewithaman.BehaviouralPatterns.CommandPattern.WithCommandPattern;

public class Client {
    public static void main(String[] args) {
        // create text editor
        TextEditor textEditor = new TextEditor();

        // create buttons
        Button button = new Button();
        button.setCommand(new BoldCommand(textEditor));
        button.setCommand(new ItalicCommand(textEditor));
        // use buttons
        button.click();
    }
}
