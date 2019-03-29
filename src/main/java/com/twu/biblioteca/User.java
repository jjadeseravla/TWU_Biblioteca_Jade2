package com.twu.biblioteca;

import org.apache.commons.lang3.StringUtils;

public  class User {

    private String libraryNumber;
    private String password;
    private boolean inSession;
    //private boolean isLibrarian;

    public User(String libraryNumber, String password) {
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.inSession = false;
        //this.isLibrarian = false;
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

//    public boolean isLibrarian() {
//        return isLibrarian;
//    }

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

}
