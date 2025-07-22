package com.codewithaman.StructuralPattern.CompositePattern.WithCompositePattern;

public class File implements FileSystemComponent{

    private String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public void addComponent(FileSystemComponent component) {
        throw new UnsupportedOperationException("Cannot add component to a file");
    }


    @Override
    public void showDetails() {
        System.out.println("File: " + this.name);
    }
}
