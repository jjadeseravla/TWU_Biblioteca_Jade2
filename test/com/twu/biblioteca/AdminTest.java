package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LibrarianUserTest {

    private LibrarianUser librarianUser;

    @Test
    public void checkIfNotLibrarian() {
        assertFalse(librarianUser.isLibrarian());
    }

    @Test
    public void checkIfLibrarian() {
        librarianUser.setLibrarian();
        assertTrue(librarianUser.isLibrarian());
    }
}
