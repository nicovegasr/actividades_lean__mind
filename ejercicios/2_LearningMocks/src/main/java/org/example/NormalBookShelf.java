package org.example;

public interface NormalBookShelf {
    void add_normal_book(Book book);
    boolean book_exists(Book book);
    Book get_normal_book(Book book);
}
