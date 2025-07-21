package com.codewithaman.BehaviouralPatterns.CommandPattern.WithCommandPattern;

// concrete implementation for command interface
public class ItalicCommand implements Command{
    TextEditor textEditor;

    public ItalicCommand(TextEditor textEditor) {
        this.textEditor = textEditor;
    }

    @Override
    public void execute() {
        textEditor.italicText();
    }
}
