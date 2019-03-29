package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

// Integration tests

public class BibliotecaAppTest {

    public void mockInput(String inputData) {
        InputStream in = new ByteArrayInputStream(inputData.getBytes());
        System.setIn(in);
    }

    ByteArrayOutputStream outContent;
    void captureOutput() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void userCanSeeAllBooksAvailable() {
        mockInput("1\n0\n");
        captureOutput();
        BibliotecaApp app = new BibliotecaApp();
        app.run();
        assertEquals("Welcome to Biblioteca! Your one-stop-shop for great book titles in Bangalore! \n" +
                "\n" +
                "0. Exit Biblioteca \n" +
                "1. Display list of books: \n" +
                "2. Checkout a book \n" +
                "3. Return a book\n" +
                "4. Display list of movies\n" +
                "The Count of MonteCristo|Alexandre Dumas|1800\n\n" +

                "The God Delusion|Richard Dawkins|1980\n\n" +

                "Sapians|Yuval Herari|2011\n\n", outContent.toString());
    }

    @Test
    public void userCanCheckoutAndReturnABook(){
        mockInput("2\nSapians\n3\nSapians\n0\n");
        captureOutput();
        BibliotecaApp app = new BibliotecaApp();
        app.run();
        assertEquals("Welcome to Biblioteca! Your one-stop-shop for great book titles in Bangalore! \n" +
                "\n" +
                "0. Exit Biblioteca \n" +
                "1. Display list of books: \n" +
                "2. Checkout a book \n" +
                "3. Return a book\n" +
                "4. Display list of movies\n" +
                "Enter the title of the book\n" +
                "you have checked out Sapians\n" +
                "Thank you, enjoy the book!\n" +
                "Enter the title of the book\n" +
                "Thank you, you have returned Sapians\n", outContent.toString());
    }

}
