package com.twu.biblioteca;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Movie;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.*;

public class InstructionTest {


    @Test
    public void shouldBeAbleToCheckOutABook() {
        Book book = new Book("testTitle", "testAuthor", 2009);
        User user = new User( "Jade", "333-4444", "password");
        Instruction instruction = new Instruction(new Book[] {book});
        assertTrue(book.isAvailable());
        instruction.checkOut("testTitle", user);
        assertFalse(book.isAvailable());
    }

    @Test
    public void unsuccessfulCheckoutOrReturnIfBookIsNotInLibrary() {
        Book book = new Book("testTitle", "testAuthor", 2009);
        User user = new User( "Jade", "333-4444", "password");
        Instruction instruction = spy(new Instruction(new Book[] {book}));
        instruction.checkOut("ble", user);
        verify(instruction).notAvailable();
    }

    @Test
    public void unsuccessfulCheckoutIfTryingToCheckItOutMoreThanOnce() {
        Book book = new Book("testTitle", "testAuthor", 2009);
        User user = new User( "Jade", "333-4444", "password");
        Instruction checkoutBook = new Instruction(new Book[] {book});
        checkoutBook.checkOut("testTitle", user);
        assertFalse(book.isAvailable());
        checkoutBook.checkOut("testTitle", user);
        assertFalse(book.isAvailable());
    }

    @Test
    public void shouldBeNotifiedIfBookHasNotBeenReturnedToCheckOutAgain() {
        Book book = new Book("testTitle", "testAuthor", 2009);
        User user = new User( "Jade", "333-4444", "password");
        Instruction instruction = spy(new Instruction(new Book[] {book}));
        instruction.checkOut("testTitle", user);
        instruction.checkOut("testTitle", user);
        verify(instruction).alreadyCheckedOut();
    }

    @Test
    public void successfulBookCheckout() {
        Book book = new Book("testTitle", "testAuthor", 2009);
        User user = new User( "Jade", "333-4444", "password");
        Instruction instruction = spy(new Instruction(new Book[] {book}));
        instruction.checkOut("testTitle", user);
        verify(instruction).successfulCheckout("testTitle");
    }

    @Test
    public void unsuccessfulReturnIfHaveNotCheckedBookOutToReturn() {
        Book book = new Book("testTitle", "testAuthor", 2009);
        User user = new User( "Jade", "333-4444", "password");
        Instruction instruction = spy(new Instruction(new Book[] {book}));
        instruction.returnABook("testTitle");
        verify(instruction).itemNotCheckedOutToReturn("testTitle");
    }


    @Test
    public void successfulReturnOfBook() {
        //mockInput("testTitle\ntestTitle\n");
        Book book = new Book("testTitle", "testAuthor", 2009);
        User user = new User( "Jade", "333-4444", "password");
        Instruction instruction = spy(new Instruction(new Book[] {book}));
        instruction.checkOut("testTitle", user);
        instruction.returnABook("testTitle");
        verify(instruction).successfulReturn("testTitle");
    }

    @Test
    public void successfulMovieCheckout() {
        Movie movie = new Movie("testTitle", 2012, "testDirector", "8");
        User user = new User( "Jade", "333-4444", "password");
        Instruction instruction = spy(new Instruction(new Movie[] {movie}));
        instruction.checkOut("testTitle", user);
        verify(instruction).successfulCheckout("testTitle");
    }

    @Test
    public void unsuccessfulCheckoutIfMovieIsNotInLibrary() {
        Movie movie = new Movie("testTitle", 2012, "testDirector", "8");
        User user = new User( "Jade", "333-4444", "password");
        Instruction instruction = spy(new Instruction(new Movie[] {movie}));
        instruction.checkOut("gaga", user);
        verify(instruction).notAvailable();
    }
}
