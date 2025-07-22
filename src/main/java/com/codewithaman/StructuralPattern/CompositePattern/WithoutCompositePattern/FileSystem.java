package com.codewithaman.StructuralPattern.CompositePattern.WithoutCompositePattern;

public class FileSystem {
    public static void main(String[] args) {
        File file1 = new File("file1.txt");
        File file2 = new File("file2.txt");
        File file3 = new File("file3.txt");
        Folder folder = new Folder("Documents");

        folder.addFile(file1);
        folder.addFile(file2);
        folder.addFile(file3);

        folder.showDetails();
    }
}
