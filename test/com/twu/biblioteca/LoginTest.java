package com.twu.biblioteca;

import com.twu.biblioteca.model.AdminMenu;
import org.junit.Before;
import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class LoginTest {

    private Login login;
    private Admin admin;
    private AdminMenu adminMenu;
    private Scanner scanner;


    @Before
    public void setUp() {
        adminMenu = mock(AdminMenu.class);
    }


    public void mockInput(String inputData) {
        login = new Login(new TestUserInput(inputData), adminMenu, admin);
    }

    @Test
    public void userChosenIfPress1() {
        mockInput("1");
        assertEquals(login.userInputNumber(), 1);
    }

    @Test
    public void librarianChosenIfPress2() {
        mockInput("2");
        assertEquals(login.userInputNumber(), 2);
    }

//    @Test
//    public void adminMenuShouldBeCalledIfUserIsLibrarian() {
//        login.setLibrarian();
//        //bibliotecaApp.checkLibrarianStatus(login);
//        verify(adminMenu).menuOptions();
//    }

}

