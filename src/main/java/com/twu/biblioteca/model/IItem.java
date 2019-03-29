package com.twu.biblioteca.model;

public interface IItem {
    String getTitle();

    String getAuthor();

    int getYear();

    boolean isAvailable();

    void setAvailable(boolean available);

    String getDirector();

    String getRating();
}
