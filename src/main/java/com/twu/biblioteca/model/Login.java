package com.twu.biblioteca.model;

import com.twu.biblioteca.User;
import com.twu.biblioteca.input.IUserInput;


public class Login {
    private IUserInput scanner;
    private boolean isLibrarian;

    public Login(IUserInput scanner) {
        this.scanner = scanner;
        this.isLibrarian = false;
    }

    public boolean isLibrarian() {
        return isLibrarian;
    }


    public void setLibrarian() {
        this.isLibrarian = true;
    }

    public int userInputNumber() {
        String line = scanner.nextLine();
        int userChoice = Integer.parseInt(line);
        return userChoice;
    }

    public void userOrLibrarian() {
        System.out.println("Please press 1 for User and 2 for Librarian:");
        if (userInputNumber() == 1) {
            setLibrarian();
        } else if (userInputNumber() == 2) {
            enterUserDetails();
        } else {
            System.out.println("Please enter a valid number");
        }
    }


    public User enterUserDetails() {
        System.out.println("Please login and enter library number and password:");
        String libraryNumber = scanner.nextLine();
        String password = scanner.nextLine();
        return new User(libraryNumber, password);
    }
}
