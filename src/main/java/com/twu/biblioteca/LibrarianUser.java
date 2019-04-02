package com.twu.biblioteca;

import com.twu.biblioteca.input.IUserInput;
import com.twu.biblioteca.model.AdminMenu;

public class LibrarianUser {
    //private IUserInput scanner;
    private boolean isLibrarian;

    public LibrarianUser() {
        this.isLibrarian = false;
    }

    public boolean isLibrarian() {
        return isLibrarian;
    }

    public void setLibrarian() {
        this.isLibrarian = true;
    }

    public void logoutLibrarian() {
        this.isLibrarian = false;
    }
}
