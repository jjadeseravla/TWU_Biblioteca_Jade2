package com.twu.biblioteca;

import com.twu.biblioteca.input.IUserInput;
import com.twu.biblioteca.model.AdminMenu;

public class Admin {
    //private IUserInput scanner;
    private boolean isAdmin;

    public Admin() {
        this.isAdmin = false;
    }

    public boolean isLibrarian() {
        return isAdmin;
    }

    public void setLibrarian() {
        this.isAdmin = true;
    }

    public void logoutLibrarian() {
        this.isAdmin = false;
    }
}
