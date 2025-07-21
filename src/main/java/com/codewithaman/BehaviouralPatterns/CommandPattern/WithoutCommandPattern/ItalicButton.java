package com.codewithaman.BehaviouralPatterns.CommandPattern.WithoutCommandPattern;

public class ItalicButton {
    TextEditor textEditor;

    public ItalicButton(TextEditor textEditor) {
        this.textEditor = textEditor;
    }

    public void italicText(String text) {
        textEditor.italicText(text);
    }
}
