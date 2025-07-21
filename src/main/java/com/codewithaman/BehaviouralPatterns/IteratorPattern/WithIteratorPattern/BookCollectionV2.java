package com.codewithaman.BehaviouralPatterns.IteratorPattern.WithIteratorPattern;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class BookCollectionV2 implements Iterable<Book> {

    private Set<Book> books;

    public BookCollectionV2() {
        this.books = new TreeSet<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public Iterator<Book> iterator() {
        return books.iterator();
    }
}
