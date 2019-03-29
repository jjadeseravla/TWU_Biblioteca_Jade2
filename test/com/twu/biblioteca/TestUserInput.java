package com.twu.biblioteca;

import com.twu.biblioteca.input.IUserInput;

public class TestUserInput implements IUserInput {
    private String[] testInputStrings;
    private int currentString = 0;
    private int testInputInteger;

    public TestUserInput(String testInputString) {
        this.testInputStrings = testInputString.split("\n");
    } // to test multiple scanner inputs

    public TestUserInput(int testInputInteger) {
        this.testInputInteger = testInputInteger;
    }

    public String nextLine() {
        String next = testInputStrings[currentString];
        currentString++;
        return next;
    }

    public int nextInt() {
        return this.testInputInteger;
    }
}
