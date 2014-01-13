package com.thoughtworks.league_manager.menu;

import lombok.AllArgsConstructor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

@AllArgsConstructor
public class UserInput {
    private PrintStream printStream;
    private BufferedReader bufferedReader;

    public String input(String prompt) {
        printStream.println(prompt);
        return userResponse();
    }

    private String userResponse() {
        String playerName;
        try {
            playerName = bufferedReader.readLine();
        } catch (IOException e) {
            throw new UncheckedIOException();
        }
        return playerName;
    }

}
