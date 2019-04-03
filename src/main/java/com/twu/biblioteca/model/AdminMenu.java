package com.twu.biblioteca.model;

import com.twu.biblioteca.Librarian;
import com.twu.biblioteca.Admin;
import com.twu.biblioteca.input.IUserInput;

public class AdminMenu {
    private IUserInput scanner;
    private Admin admin;
    private Librarian librarian;

    public AdminMenu(IUserInput scanner, Admin admin, Librarian librarian) {
        this.scanner = scanner;
        this.admin = admin;
        this.librarian = librarian;
    }

    public String menuOptions() {
        return  "0. Exit Biblioteca\n" +
                "1. Books that have been checked out by users\n" +
                "2. User logout";
    }

    public int inputFromUser() {
        try {
            String line = scanner.nextLine();
            int userChoice = Integer.parseInt(line);
            return userChoice;
        }
        catch( NumberFormatException e) {
            return -1;
        }
    }


    public boolean processCommand() {
        int userChoice = inputFromUser();
        switch(userChoice) {
            case 0:
                //System.exit(0);
                return true;
            case 1:
                librarian.printUsersAndBooks();
                break;
            case 2:
                admin.logoutLibrarian();
                return true;
            default:
                invalidMessage();
                break;
        }
        return false;
    }

    public void selector() {
        while(true) {
            boolean finish = processCommand();
            if(finish) break;
        }
    }

    public void invalidMessage() {
        System.out.println("Please select another menu option");
    }
}







