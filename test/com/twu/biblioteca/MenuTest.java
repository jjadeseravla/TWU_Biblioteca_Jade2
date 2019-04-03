package com.twu.biblioteca;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Menu;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class MenuTest {

    private Menu menu;
    private String EXPECTED_MESSAGE = "Welcome to Biblioteca! Your one-stop-shop for great book titles in Bangalore! \n";
    private Book[] books = new Book[1];
    private Librarian librarian;
    private Scanner scanner;
    private Instruction instruction;
    private User user;

    @Before
    public void setUp() {
        librarian = mock(Librarian.class);
        instruction = mock(Instruction.class);
        user = new User("Jade", "333-4444", "password");
    }

    @Test
    public void shouldDisplayWelcomeMessage() {
        mockInput("");
        String message = menu.getWelcomeMessage();
        assertEquals(menu.getWelcomeMessage(), EXPECTED_MESSAGE);
    }

    public void mockInput(String inputData) {
        //InputStream in = new ByteArrayInputStream(inputData.getBytes());
        //scanner = new Scanner(in);
        menu = new Menu(new TestUserInput(inputData), librarian, user);
    }

    @Test
    public void shouldBeAbleToSelectOptionsOnMenu() {
        mockInput("1\n3\n2\n");
        assertEquals(menu.inputFromUser(), 1);
        assertEquals(menu.inputFromUser(), 3);
        assertEquals(menu.inputFromUser(), 2);
    }

    @Test
    public void shouldBeAbleToSelectUnavailableOption() {
        mockInput("7\n");
        assertEquals(menu.inputFromUser(), 7);
    }

    @Test
    public void shouldBeAbleToTypeNotANumberAsOption() {
        mockInput("lol\n");
        assertEquals(menu.inputFromUser(), -1);
    }

    ByteArrayOutputStream outContent;
    void captureOutput() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void notifiedInvalidOption() {
        mockInput("7\n");
        captureOutput();
        menu.invalidMessage();
        assertEquals("Please select another menu option\n", outContent.toString());
    }


}
