package com.twu.biblioteca;

import com.twu.biblioteca.input.IUserInput;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Movie;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Librarian {
    private Instruction <Book> bookInstruction;
    private Instruction <Movie> movieInstruction;
    private IUserInput scanner;

    public Librarian(IUserInput scanner, Instruction<Book> bookInstruction, Instruction<Movie> movieInstruction) {
        this.scanner = scanner;
        this.bookInstruction = bookInstruction;
        this.movieInstruction = movieInstruction;
    }

    public void listBooks() {
        Book [] books = bookInstruction.getItems();
        for (int i = 0; i < books.length; i++) {
            if (books[i].isAvailable()) {
                System.out.println(String.format("%s|", books[i].getTitle()) + books[i].getAuthor() + String.format("|%d", books[i].getYear()) + "\n");
            }
        }
    }

    public void listMovies() {
        Movie [] movies = movieInstruction.getItems();
        for (int i = 0; i < movies.length; i++) {
            if (movies[i].isAvailable()) {
                System.out.println(String.format("%s|", movies[i].getTitle()) + String.format("%d|", movies[i].getYear()) + String.format("%s|", movies[i].getDirector()) + String.format("%s", movies[i].getRating()) + "\n");
            }
        }
    }

    public void checkMovieOut(User user) {
        String title = enterTitle();
        movieInstruction.checkOut(title, user);
    }

    public void checkBookOut(User user) {
        String title = enterTitle();
        bookInstruction.checkOut(title, user);
    }

    public void returnABook() {
        String title = enterTitle();
        bookInstruction.returnABook(title);
    }

    public String enterTitle() {
        System.out.println("Enter the title of the book");
        String title = scanner.nextLine();
        return title;
    }

    public void printUsersAndBooks() {
        Set set = bookInstruction.getItemUsersMap().entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry)iterator.next();
            System.out.print("This book: "+ mentry.getKey().getClass().getName() + " was checked out by ");
            System.out.println(mentry.getValue().getClass().getName());
        }
    }

    //Map<T, User> itemUserMap;
    //itemUserMap.put(item, user);
}
