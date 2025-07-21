package com.codewithaman.BehaviouralPatterns.IteratorPattern.WithIteratorPattern;

import java.util.Iterator;

public class ClientV2 {
    public static void main(String[] args) {
        BookCollectionV2 bookCollection = new BookCollectionV2();
        bookCollection.addBook(new Book("Java Book"));
        bookCollection.addBook(new Book("Python Book"));
        bookCollection.addBook(new Book("C++ Book"));
        bookCollection.addBook(new Book("Golang Book"));
        bookCollection.addBook(new Book("C Book"));

        Iterator<Book> it = bookCollection.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
