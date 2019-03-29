package com.twu.biblioteca;
import com.twu.biblioteca.input.IUserInput;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Movie;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class LibrarianTest {

    private Book book1;
    private Book book2;
    private Movie movie1;
    private Movie movie2;
    private Librarian librarian;
    private IUserInput scanner;
    private Instruction instruction;

    public Librarian createLibrarian(IUserInput userInput) {
        book1 = new Book("testbook1", "testauthor1", 1999);
        movie1 = new Movie("testMovie1", 2011, "testDirector1", "7");
        Instruction bookInstruction = new Instruction<Book>(new Book[]{book1});
        Instruction movieInstruction = new Instruction<Movie>(new Movie[]{movie1});
        return new Librarian(userInput, bookInstruction, movieInstruction);
    }

    @Before
    public void setUp() {
        scanner = mock(IUserInput.class);
        instruction = mock(Instruction.class);
    }

    @Test
    public void shouldBeAbleToEnterABookTitle() {
        String testTitle = "testbook1";
        Librarian librarian = createLibrarian(new TestUserInput(testTitle));
        assertEquals(librarian.enterTitle(), testTitle);
    }


    @Test
    public void canListAllBooksFormatted() {
        String testTitle = "";
        Librarian librarian = createLibrarian(new TestUserInput(testTitle));
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        librarian.listBooks();
        assertEquals("testbook1|testauthor1|1999\n\n", outContent.toString());
    }

        @Test
    public void shouldListMoviesFormatted() {
        String testTitle = "";
        Librarian librarian = createLibrarian(new TestUserInput(testTitle));
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        librarian.listMovies();
        assertEquals("testMovie1|2011|testDirector1|7\n\n",outContent.toString());
    }
}
