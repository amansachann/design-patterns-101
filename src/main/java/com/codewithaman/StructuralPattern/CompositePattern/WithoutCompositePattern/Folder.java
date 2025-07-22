package com.codewithaman.StructuralPattern.CompositePattern.WithoutCompositePattern;

import java.util.ArrayList;
import java.util.List;

public class Folder {
    private String name;
    private List<File> files;

    public Folder(String name) {
        this.name = name;
        this.files = new ArrayList<>();
    }

    public void addFile(File file) {
        files.add(file);
    }

    public void showDetails() {
        System.out.println("Folder: " + name);
        for(File file: files) {
            file.showDetails();
        }
    }
}
