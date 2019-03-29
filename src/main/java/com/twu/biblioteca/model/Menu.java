package com.twu.biblioteca.model;

import com.twu.biblioteca.User;
import com.twu.biblioteca.input.IUserInput;
import com.twu.biblioteca.Librarian;

public class Menu {
    private static final String WELCOME_MESSAGE = "Welcome to Biblioteca! Your one-stop-shop for great book titles in Bangalore! \n";
    private Librarian librarian;
    private IUserInput scanner;
    private User user;

    public Menu(IUserInput scanner, Librarian librarian, User user) {
        this.scanner = scanner;
        this.librarian = librarian;
        this.user = user;
    }

    public String getWelcomeMessage() {
        return WELCOME_MESSAGE;
    }

        public String showMenuOptions() {
            return  "0. Exit Biblioteca\n" +
                    "1. Display list of books\n" +
                    "2. Checkout a book \n" +
                    "3. Return a book\n" +
                    "4. Display list of movies\n" +
                    "5. Checkout a movie\n" +
                    "6. User logout";
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
                    System.exit(0);
                    return true;
                case 1:
                    librarian.listBooks();
                    break;
                case 2:
                    librarian.checkBookOut(user);
                    break;
                case 3:
                    librarian.returnABook();
                    break;
                case 4:
                    librarian.listMovies();
                    break;
                case 5:
                    librarian.checkMovieOut(user);
                    break;
                case 6:
                    user.logout();
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






