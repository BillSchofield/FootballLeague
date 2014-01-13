package com.thoughtworks.league_manager.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

@Component
public class UserInput {
    private PrintStream printStream;
    private BufferedReader bufferedReader;

    @Autowired
    public UserInput(PrintStream printStream, BufferedReader bufferedReader) {
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
    }

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
