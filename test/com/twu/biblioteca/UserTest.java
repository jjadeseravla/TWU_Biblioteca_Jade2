package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
//import static org.junit.Assert.assertTrue;

public class UserTest {

    private User user;

    @Before
    public void setUp() {
        user = new User("Jade", "333-4444", "password");
    }

    @Test
    public void shouldBeAbleToLoginAsUser() {
        user.login();
        assertTrue(user.isInSession());
    }

    @Test
    public void canValidateUserLibraryNumber() {
        assertFalse(user.validate("728-496"));
        assertFalse(user.validate("7-28496"));
        assertFalse(user.validate("thesearewords"));
    }

    @Test
    public void shouldBeAbleToLogout() {
        user.login();
        assertTrue(user.isInSession());
        user.logout();
        assertFalse(user.isInSession());
    }

}
