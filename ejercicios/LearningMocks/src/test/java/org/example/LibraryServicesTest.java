package org.example;


import io.vavr.control.Either;
import org.junit.jupiter.api.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class LibraryServicesTest {
    /* Use cases:
     * 1. Put a new normal book in my bookshelf.
     * 2. Try to put an existent book in my bookshelf -> Error: BOOK_ALREADY_EXISTS.
     * 3. Get a normal book from my bookshelf.
     * 4. Try to get a nonexistent book from by bookshelf -> Error: NONEXISTENT_BOOK.
     */
    Book book;
    LibraryServices libraryServices;
    NormalBookShelf normalBookShelf;
    @BeforeEach
    public void setUp() {
        normalBookShelf = mock(NormalBookShelf.class);
        libraryServices = new LibraryServices(normalBookShelf);
    }
    @Test
    public void put_a_book_in_my_bookshelf() {
        book = Book.NORMAL_BOOK;

        Either<BookWarning, Book> response = libraryServices.put_a_book(book);

        verify(normalBookShelf).add_normal_book(book);
        assertTrue(response.isRight());
    }
    @Test
    public void try_to_put_an_existent_book_in_my_bookshelf() {
        book = Book.NORMAL_BOOK;

        when(normalBookShelf.book_exists(book)).thenReturn(true);
        Either<BookWarning, Book> response = libraryServices.put_a_book(book);

        verify(normalBookShelf, never()).add_normal_book(book);
        assertEquals(response.getLeft(), BookWarning.BOOK_ALREADY_EXISTS);
    }
    @Test
    public void get_a_book_from_my_bookshelf() {
        book = Book.NORMAL_BOOK;

        when(normalBookShelf.get_normal_book(book)).thenReturn(book);
        Either<BookWarning, Book> response = libraryServices.get_a_book(book);

        assertTrue(response.isRight());
    }
}