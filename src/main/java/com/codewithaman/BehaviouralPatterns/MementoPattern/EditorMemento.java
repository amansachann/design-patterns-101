package com.codewithaman.BehaviouralPatterns.MementoPattern;

// Memento Class: Stores the Internal State of the TextEditor
public class EditorMemento {
    private final String content;

    public EditorMemento(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
