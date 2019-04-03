package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AdminTest {

    private Admin admin;

    @Test
    public void checkIfNotLibrarian() {
        assertFalse(admin.isLibrarian());
    }

    @Test
    public void checkIfLibrarian() {
        admin.setLibrarian();
        assertTrue(admin.isLibrarian());
    }
}
