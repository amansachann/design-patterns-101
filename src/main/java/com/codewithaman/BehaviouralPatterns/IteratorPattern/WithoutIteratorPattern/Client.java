package com.codewithaman.BehaviouralPatterns.IteratorPattern.WithoutIteratorPattern;

public class Client {
    public static void main(String[] args) {
        BookCollection bookCollection = new BookCollection();
        bookCollection.addBook(new Book("Java Book"));
        bookCollection.addBook(new Book("Python Book"));
        bookCollection.addBook(new Book("C++ Book"));
        bookCollection.addBook(new Book("Golang Book"));
        bookCollection.addBook(new Book("C Book"));

        for(int i = 0; i < bookCollection.getBooks().size(); i++) {
            System.out.println(bookCollection.getBooks().get(i));
        }


        // Problem:
        // If tomorrow the book collection implementation is changed
        // suppose from arraylist to set,
        // then our code will break,
        // Therefore, we need to use an iterator pattern here.
    }
}
