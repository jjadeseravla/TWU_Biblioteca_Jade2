package com.twu.biblioteca.model;

import com.twu.biblioteca.CheckUser;
import com.twu.biblioteca.input.IUserInput;

public class AdminMenu {
    private IUserInput scanner;
    private CheckUser checkUser;

    public AdminMenu(IUserInput scanner, CheckUser checkUser) {
        this.scanner = scanner;
        this.checkUser = checkUser;
    }


    public String menuOptions() {
        return  "0. Exit Biblioteca\n" +
                "1. Who has checked out a book\n" +
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
//            case 1:
//                librarian.listBooks();
//                break;
//            case 2:
//                CheckUser.logout();
//                return true;
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







