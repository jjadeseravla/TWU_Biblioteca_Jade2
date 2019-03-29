package com.twu.biblioteca.input;

import com.twu.biblioteca.input.IUserInput;

import java.util.Scanner;

public class UserInputScanner implements IUserInput {

    private final Scanner scanner;

    public UserInputScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public String nextLine() {
        return scanner.nextLine();
    }

    public int nextInt() {
        return scanner.nextInt();
    }
}
