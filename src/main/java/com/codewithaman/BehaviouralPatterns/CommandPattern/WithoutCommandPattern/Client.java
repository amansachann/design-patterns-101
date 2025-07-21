package com.codewithaman.BehaviouralPatterns.CommandPattern.WithoutCommandPattern;

public class Client {

    public static void main(String[] args) {
        // Create a text editor
        TextEditor textEditor = new TextEditor();

        // Create the UI Buttons
        BoldButton boldButton = new BoldButton(textEditor);
        ItalicButton italicButton = new ItalicButton(textEditor);

        // Use those buttons
        italicButton.italicText("This is italic text");
        boldButton.boldText("This is bold text");
    }
}
