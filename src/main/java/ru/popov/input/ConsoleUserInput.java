package ru.popov.input;

import java.util.Scanner;

public class ConsoleUserInput implements UserInput {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void showToUser(String message) {
        System.out.println(message);
    }

    @Override
    public String getFromUser() {
        return scanner.nextLine();
    }
}
