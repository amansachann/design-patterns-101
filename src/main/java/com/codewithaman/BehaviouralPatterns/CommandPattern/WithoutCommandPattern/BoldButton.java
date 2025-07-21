package com.codewithaman.BehaviouralPatterns.CommandPattern.WithoutCommandPattern;

public class BoldButton {

    TextEditor textEditor;

    public BoldButton(TextEditor textEditor) {
        this.textEditor = textEditor;
    }

    public void boldText(String text) {
        textEditor.boldText(text);
    }
}
