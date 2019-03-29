package com.twu.biblioteca.model;

import com.twu.biblioteca.model.IItem;

public class Book implements IItem {
    private String title;
    private String Author;
    private int Year;
    private boolean available = true;

    public Book(String title, String Author, int Year) {
        this.title = title;
        this.Author = Author;
        this.Year = Year;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return Author;
    }

    public int getYear() {
        return Year;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getDirector() {
        return "";
    }

    public String getRating() {
        return "";
    }
}
