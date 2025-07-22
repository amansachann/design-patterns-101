package com.codewithaman.StructuralPattern.CompositePattern.WithCompositePattern;

public class FileSystemClient {
    public static void main(String[] args) {
        FileSystemComponent doc1 = new File("file1.txt");
        FileSystemComponent doc2 = new File("file2.txt");
        FileSystemComponent doc3 = new File("file3.txt");

        FileSystemComponent folder1 = new Folder("Documents");
        // Add files to the folder
        folder1.addComponent(doc1);
        folder1.addComponent(doc2);
        folder1.addComponent(doc3);

        FileSystemComponent folder2 = new Folder("Images");
        FileSystemComponent img1 = new File("img1.jpg");
        FileSystemComponent img2 = new File("img2.jpg");
        FileSystemComponent img3 = new File("img3.jpg");
        folder2.addComponent(img1);
        folder2.addComponent(img2);
        folder2.addComponent(img3);

        folder1.addComponent(folder2);

        // Now show the details
        folder1.showDetails();

    }
}
