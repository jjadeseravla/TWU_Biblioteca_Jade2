package com.twu.biblioteca.model;

import com.twu.biblioteca.model.IItem;

public class Movie implements IItem {
    private String title;
    private int year;
    private String director;
    private String rating;
    private boolean available = true;

    public Movie(String title, int year, String director) {
        this.title = title;
        this.year = year;
        this.director = director;
        this.rating = "unrated";
    }

    public Movie(String title, int year, String director, String rating) {
        this.title = title;
        this.year = year;
        this.director = director;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return null;
    }

    public int getYear() {
        return year;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) { this.available = available; }

    public String getDirector() {
        return director;
    }

    public String getRating() {
        return rating;
    }


}
