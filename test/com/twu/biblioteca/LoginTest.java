//package com.twu.biblioteca;
//
//import com.twu.biblioteca.model.AdminMenu;
//import org.junit.Before;
//import org.junit.Test;
//
//import static org.junit.Assert.*;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.verify;
//
//public class LoginTest {
//
//    private Login login;
//    private AdminMenu adminMenu;
//
//
//    @Before
//    public void setUp() {
//
//        login = new Login();
//        //bibliotecaApp = new BibliotecaApp();
//        //adminMenu = mock(AdminMenu.class);
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

//    @Test
//    public void checkLibrarianStatus() {
//        login.setLibrarian();
//        assertTrue(bibliotecaApp.checkLibrarianStatus(login));
//    }
//
//    @Test
//    public void adminMenuShouldBeCalledIfUserIsLibrarian() {
//        login.setLibrarian();
//        bibliotecaApp.checkLibrarianStatus(login);
//        verify(adminMenu).menuOptions();
//    }

//}

