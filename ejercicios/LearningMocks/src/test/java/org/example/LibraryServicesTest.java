package org.example;

import org.junit.Test;


import static org.mockito.Mockito.*;

public class LibraryServicesTest {
    /* Use cases:
     * 1. Put a new normal book in my bookshelf.
     * 2. Get a normal book from my bookshelf.
     * 3. Try to put an existent book in my bookshelf -> Error: BOOK_ALREADY_EXISTS.
     * 4. Try to get a nonexistent book from by bookshelf -> Error: NONEXISTENT_BOOK.
     */
    @Test
    public void put_a_book_in_my_bookshelf() {
        Book book = Book.NORMAL_BOOK;
        LibraryServices libraryServices = new LibraryServices();
        NormalBookShelf normalBookShelf = mock(NormalBookShelf.class);

        libraryServices.put_a_book(book, normalBookShelf);

        verify(normalBookShelf).add_normal_book(book);

    }
}