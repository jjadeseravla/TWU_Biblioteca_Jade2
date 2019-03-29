package com.twu.biblioteca;
import com.twu.biblioteca.model.Book;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class BookTest {

    private Book book1Test;

    @Before
    public void setUp() {
        book1Test = new Book("my life", "me", 1991);
    }

    @Test
    public void getTitleTest() {
        assertEquals(book1Test.getTitle(), "my life");
    }

    @Test
    public void showsIfBookIsAvailableBeforeCheckingOut() {
        assertTrue(book1Test.isAvailable());
    }

}
