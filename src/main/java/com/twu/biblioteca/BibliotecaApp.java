
package com.twu.biblioteca;

        import com.twu.biblioteca.input.IUserInput;
        import com.twu.biblioteca.input.UserInputScanner;
        import com.twu.biblioteca.model.*;

        import java.util.ArrayList;
        import java.util.List;
        import java.util.Scanner;

public class BibliotecaApp {

    private List<String> userHistory;

    public BibliotecaApp() {
        this.userHistory = new ArrayList<String>();
        //user:listofboooks
    }


    public Book[] setupBooks() {
        Book book1 = new Book("The Count of MonteCristo", "Alexandre Dumas", 1800);
        Book book2 = new Book("The God Delusion", "Richard Dawkins", 1980);
        Book book3 = new Book("Sapians", "Yuval Herari", 2011);
        return new Book[]{book1, book2, book3};
    }

    public Movie[] setupMovies() {
        Movie movie1 = new Movie("Titanic", 1997, "director1");
        Movie movie2 = new Movie("Bohemium Rhapsody", 2019, "director2", "9");
        Movie movie3 = new Movie("Schindler's list", 1994, "Stephen Spielberg", "8");
        return new Movie[]{movie1, movie2, movie3};
    }

    public boolean checkLibrarianStatus(Login login) { //check in login if librarian is false or true by passing it in
        return login.isLibrarian();
    }


    public void run() {

        Scanner scanner = new Scanner(System.in);
        IUserInput input = new UserInputScanner(scanner);
        IUserInput inputNum = new UserInputScanner(scanner);
        AdminMenu adminMenu = new AdminMenu(input);
        Login login = new Login(inputNum, adminMenu);

        Book[] books = setupBooks();
        Movie[] movies = setupMovies();

        Instruction<Book> bookInstruction = new Instruction<Book>(books); //<> this is an instruction of books
        Instruction<Movie> movieInstruction = new Instruction<Movie>(movies);
        Librarian librarian = new Librarian(input, bookInstruction, movieInstruction);

//        if (checkLibrarianStatus(login)) {
//            System.out.println(adminMenu.menuOptions());
//            adminMenu.selector();
//
//        } else {

            // User user = new User("333-4444", "password");
            while (true) {
                login.userOrLibrarian();


                if (checkLibrarianStatus(login)) { //1
                    System.out.println(adminMenu.menuOptions());
                    adminMenu.selector();

                } else { //2

                User user = login.enterUserDetails();
                Menu menu = new Menu(input, librarian, user);
                System.out.println(menu.getWelcomeMessage());
                user.login();
                if (!user.isInSession()) {
                    System.out.println("invalid user library number");
                } else {
                    userHistory.add(user.getLibraryNumber());
                    System.out.println(menu.showMenuOptions());
                    menu.selector();
                }
                // if libraria2
                // n display logged in users
            }

            
        }
    }

}
