package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    private Library library;

    @BeforeEach
    void setUp() {
        ArrayList<Book> fiction = new ArrayList<>();
        fiction.add(new Book("Fiction Book 1", "Author F1"));
        fiction.add(new Book("Fiction Book 2", "Author F2"));
        fiction.add(new Book("Fiction Book 3", "Author F3"));

        ArrayList<Book> nonFiction = new ArrayList<>();
        nonFiction.add(new Book("NonFiction Book 1", "Author NF1"));
        nonFiction.add(new Book("NonFiction Book 2", "Author NF2"));

        ArrayList<Book> mystery = new ArrayList<>();
        mystery.add(new Book("Mystery Book 1", "Author M1"));
        mystery.add(new Book("Mystery Book 2", "Author M2"));
        mystery.add(new Book("Mystery Book 3", "Author M3"));
        mystery.add(new Book("Mystery Book 4", "Author M4"));

        library = new Library(fiction, nonFiction, mystery);
    }

    @Test
    void testGetAuthor() {
        assertEquals("Author F1", library.getAuthor("Fiction", 0));
        assertEquals("Author F3", library.getAuthor("Fiction", 2));
        assertEquals("Author NF2", library.getAuthor("NonFiction", 1));
        assertEquals("Author M4", library.getAuthor("Mystery", 3));
    }

    @Test
    void testGetTitle() {
        assertEquals("Fiction Book 2", library.getTitle("Fiction", 1));
        assertEquals("NonFiction Book 1", library.getTitle("NonFiction", 0));
        assertEquals("Mystery Book 3", library.getTitle("Mystery", 2));
    }

    @Test
    void testAddBookAtStartMiddleEnd() {
        Book startBook = new Book("Start Mystery", "Start Author");
        Book middleBook = new Book("Middle Fiction", "Middle Author");
        Book endBook = new Book("End NonFiction", "End Author");

        // Add to beginning
        library.addBook("Mystery", 0, startBook);
        assertEquals("Start Mystery", library.getTitle("Mystery", 0));

        // Add to middle
        library.addBook("Fiction", 1, middleBook);
        assertEquals("Middle Fiction", library.getTitle("Fiction", 1));
        assertEquals("Fiction Book 2", library.getTitle("Fiction", 2)); 

        // Add to end
        int lastIndex = 2; // NonFiction currently has 2 elements
        library.addBook("NonFiction", lastIndex + 1, endBook);
        assertEquals("End NonFiction", library.getTitle("NonFiction", 3));
    }

    @Test
    void testRemoveBookFromStartMiddleEnd() {
        // Remove first
        library.removeBook("Mystery", 0);
        assertEquals("Mystery Book 2", library.getTitle("Mystery", 0));

        // Remove middle
        library.removeBook("Fiction", 1); // Removes Fiction Book 2
        assertEquals("Fiction Book 3", library.getTitle("Fiction", 1));
    }

}
