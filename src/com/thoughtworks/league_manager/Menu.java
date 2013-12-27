package com.thoughtworks.league_manager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

import static java.lang.Integer.parseInt;

public class Menu {
    private PrintStream printStream;
    private BufferedReader bufferedReader;
    private List<Command> commands;

    public Menu(PrintStream printStream, BufferedReader bufferedReader, List<Command> commands) {
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
        this.commands = commands;
    }

    public Command userOption() throws IOException {
        printStream.println("Please enter the number of the option you choose");
        listOptions();
        return commands.get(readOptionNumber());
    }

    private int readOptionNumber() throws IOException {
        String userInput = bufferedReader.readLine();
        return parseInt(userInput) - 1;
    }

    private void listOptions() {
        int commandNumber = 1;
        for (Command command : commands){
            printStream.println(commandNumber++ + ") " + command.name());
        }
    }
}
