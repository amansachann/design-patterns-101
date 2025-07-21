package com.codewithaman.BehaviouralPatterns.IteratorPattern.WithIteratorPattern;

import java.util.Iterator;

public class Client {
    public static void main(String[] args) {
        BookCollection bookCollection = new BookCollection();
        bookCollection.addBook(new Book("Java Book"));
        bookCollection.addBook(new Book("Python Book"));
        bookCollection.addBook(new Book("C++ Book"));
        bookCollection.addBook(new Book("Golang Book"));
        bookCollection.addBook(new Book("C Book"));

        Iterator it = bookCollection.createIterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
