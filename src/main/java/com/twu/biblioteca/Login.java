package com.twu.biblioteca;

import com.twu.biblioteca.input.IUserInput;
import com.twu.biblioteca.model.AdminMenu;


public class Login {
    private IUserInput scanner;
    private AdminMenu adminMenu;
    private Admin admin;

    public Login(IUserInput scanner, AdminMenu adminMenu, Admin admin) {
        this.scanner = scanner;
        this.adminMenu = adminMenu;
        this.admin = admin;
    }

    public int userInputNumber() {
        String line = scanner.nextLine();
        int userInputNum = Integer.parseInt(line);
        return userInputNum;
    }

    public void userOrLibrarian() {
        System.out.println("Please press 1 for Librarian and 2 for User:");

        switch(userInputNumber()){
            case 1:
                admin.setLibrarian();
                break;
            case 2:
                System.out.println("you have chosen user");
                break;
            default:
                System.out.println("Please enter either 1 or 2");

        }

//        if (userInputNumber() == 1) {
//            setLibrarian();
//            //adminMenu.menuOptions();
//        } else
////            if (userInputNumber() == 2)
//            {
//            //enterUserDetails();
//            System.out.println("you have chosen user");
//        }
//        else {
//            System.out.println("Please enter either 1 or 2");
//        }


    }


    public User enterUserDetails() {
        System.out.println("Please login and enter name, library number and password:");
        String name = scanner.nextLine();
        String libraryNumber = scanner.nextLine();
        String password = scanner.nextLine();
        return new User(name, libraryNumber, password);
    }
}
