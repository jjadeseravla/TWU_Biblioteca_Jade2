//package com.twu.biblioteca;
//
//import com.twu.biblioteca.input.IUserInput;
//import com.twu.biblioteca.model.AdminMenu;
//import com.twu.biblioteca.model.Menu;
//import org.junit.Before;
//import org.junit.Test;
//
//import java.util.Scanner;
//
//import static org.junit.Assert.*;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.verify;
//
//public class LoginTest {
//
//    private Login login;
//    private AdminMenu adminMenu;
//    private Scanner scanner;
//
//
//    @Before
//    public void setUp() {
//        adminMenu = mock(AdminMenu.class);
//        //scanner = mock(IUserInput.class);
//        //login = new Login(scanner, adminMenu);
//    }
//
//    @Test
//    public void checkIfNotLibrarian() {
//        assertFalse(login.isLibrarian());
//    }
//
//    @Test
//    public void checkIfLibrarian() {
//        login.setLibrarian();
//        assertTrue(login.isLibrarian());
//    }
//
//    public void mockInput(String inputData) {
//        login = new Login(new TestUserInput(inputData), adminMenu);
//    }
//
//    @Test
//    public void userChosenIfPress1() {
//        mockInput("1");
//        assertEquals(login.userInputNumber(), 1);
//    }
//
//    @Test
//    public void librarianChosenIfPress2() {
//        mockInput("2");
//        assertEquals(login.userInputNumber(), 2);
//    }
//
////    @Test
////    public void adminMenuShouldBeCalledIfUserIsLibrarian() {
////        login.setLibrarian();
////        //bibliotecaApp.checkLibrarianStatus(login);
////        verify(adminMenu).menuOptions();
////    }
//
//}
//
