package com.twu.biblioteca;

import com.twu.biblioteca.input.IUserInput;
import com.twu.biblioteca.model.AdminMenu;

public class Admin {
    //private IUserInput scanner;
    private boolean isLibrarian;

    public Admin() {
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
