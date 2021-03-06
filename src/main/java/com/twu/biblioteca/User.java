package com.twu.biblioteca;

import org.apache.commons.lang3.StringUtils;

public  class User {

    private String name;
    private String libraryNumber;
    private String password;
    private boolean inSession;
    //private boolean isLibrarian;

    public User(String name, String libraryNumber, String password) {
        this.name = name;
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.inSession = false;
    }

    public String getName() {
        return name;
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    public void setLibraryNumber(String libraryNumber) {
        this.libraryNumber = libraryNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isInSession() {
        return inSession;
    }


    protected boolean validate(String libraryNumber) {
        int numParts = libraryNumber.length();
        if(numParts != 8) {
            return false;
        }

        if(!StringUtils.isNumeric(libraryNumber.substring(3)) && !StringUtils.isNumeric(libraryNumber.substring(4,8))) {
            return false;
        }

        if("-".equals(libraryNumber.substring(4))) {
            return false;
        }

        return true;
    }

    public void login() {
        this.inSession = validate(this.libraryNumber);
    }

    public void logout() {
        this.inSession = false;
    }

    public void showInfo() {
        System.out.println("Your name is: " + getName());
        System.out.println("Your library number is: " + getLibraryNumber());
        System.out.println("Your password is: " + getPassword());
    }

}
