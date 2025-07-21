package com.codewithaman.BehaviouralPatterns.CommandPattern.WithCommandPattern;

public class UnderlineCommand implements Command{
    TextEditor textEditor;

    public UnderlineCommand(TextEditor textEditor) {
        this.textEditor = textEditor;
    }

    @Override
    public void execute() {
        textEditor.underlineText();
    }
}
