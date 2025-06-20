package com.codewithaman.BehaviouralPatterns.MementoPattern;

public class TextEditorMain {

    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor();
        Caretaker caretaker = new Caretaker();
        textEditor.write("Hello World");
        caretaker.saveState(textEditor);
        textEditor.write("Hello Everyone");
        caretaker.saveState(textEditor);
//        Problem -> Revert to previous state
        caretaker.undo(textEditor);
        System.out.println(textEditor.getContent());

    }
}
