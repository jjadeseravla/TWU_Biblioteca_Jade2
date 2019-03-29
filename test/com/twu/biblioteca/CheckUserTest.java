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
//public class CheckUserTest {
//
//    private CheckUser checkUser;
//    private BibliotecaApp bibliotecaApp;
//    private AdminMenu adminMenu;
//
//
//    @Before
//    public void setUp() {
//
//        checkUser = new CheckUser();
//        bibliotecaApp = new BibliotecaApp();
//        adminMenu = mock(AdminMenu.class);
//    }
//
//    @Test
//    public void checkIfNotLibrarian() {
//        assertFalse(checkUser.isLibrarian());
//    }
//
//    @Test
//    public void checkIfLibrarian() {
//        checkUser.setLibrarian();
//        assertTrue(checkUser.isLibrarian());
//    }
//
//    @Test
//    public void checkLibrarianStatus() {
//        checkUser.setLibrarian();
//        assertTrue(bibliotecaApp.checkLibrarianStatus(checkUser));
//    }
//
//    @Test
//    public void adminMenuShouldBeCalledIfUserIsLibrarian() {
//        checkUser.setLibrarian();
//        bibliotecaApp.checkLibrarianStatus(checkUser);
//        verify(adminMenu).menuOptions();
//    }
//
//}
