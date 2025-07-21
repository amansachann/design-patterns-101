package com.codewithaman.BehaviouralPatterns.CommandPattern.WithCommandPattern;

// Concrete implementation of command interface
public class BoldCommand implements Command{
    TextEditor textEditor;

    public BoldCommand(TextEditor textEditor) {
        this.textEditor = textEditor;
    }

    @Override
    public void execute() {
        textEditor.boldText();
    }
}
