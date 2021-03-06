
package com.twu.biblioteca;

        import com.twu.biblioteca.input.IUserInput;
        import com.twu.biblioteca.input.UserInputScanner;
        import com.twu.biblioteca.model.*;

        import java.util.*;

public class BibliotecaApp {

    private List<String> userHistory;

    public BibliotecaApp() {
        this.userHistory = new ArrayList<String>();
        //user:listofboooks
    }


    public Book[] setupBooks() {
        Book book1 = new Book("The Count of MonteCristo", "Alexandre Dumas", 1800);
        Book book2 = new Book("The God Delusion", "Richard Dawkins", 1980);
        Book book3 = new Book("Sapiens", "Yuval Herari", 2011);
        Book book4 = new Book("1984", "George Orwell", 1949);
        Book book5 = new Book("got", "George R R Martin", 2000);

        return new Book[]{book1, book2, book3, book4, book5};
    }

    public Movie[] setupMovies() {
        Movie movie1 = new Movie("Titanic", 1997, "director1");
        Movie movie2 = new Movie("Bohemium Rhapsody", 2019, "director2", "9");
        Movie movie3 = new Movie("Schindler's list", 1994, "Stephen Spielberg", "8");
        Movie movie4 = new Movie("Toy Story", 1995, "John Leseter", "7");
        Movie movie5 = new Movie("Her", 2015, "Joaquin Phoenix", "7");
        return new Movie[]{movie1, movie2, movie3, movie4, movie5};
    }

    public boolean checkLibrarianStatus(Admin admin) { //check in login if librarian is false or true by passing it in
        return admin.isLibrarian();
    }


    public void run() {

        Scanner scanner = new Scanner(System.in);
        IUserInput input = new UserInputScanner(scanner);
        IUserInput inputNum = new UserInputScanner(scanner);
        Admin admin = new Admin();

        Book[] books = setupBooks();
        Movie[] movies = setupMovies();

        Instruction<Book> bookInstruction = new Instruction<Book>(books);//<> this is an instruction of books
        Instruction<Movie> movieInstruction = new Instruction<Movie>(movies);
        Librarian librarian = new Librarian(input, bookInstruction, movieInstruction);
        AdminMenu adminMenu = new AdminMenu(input, admin, librarian);
        Login login = new Login(inputNum, adminMenu, admin);

            while (true) {
                login.userOrLibrarian();


                if (checkLibrarianStatus(admin)) { //1
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
                // if librarian2
                // n display logged in users
            }
            
        }
    }

}
