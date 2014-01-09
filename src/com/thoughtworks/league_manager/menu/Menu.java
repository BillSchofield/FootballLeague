package com.thoughtworks.league_manager.menu;

import com.thoughtworks.league_manager.command.Command;
import com.thoughtworks.league_manager.command.QuitCommand;

import java.io.IOException;
import java.util.List;

import static java.lang.Integer.parseInt;

public class Menu {
    private List<Command> commands;
    private UserInput userInput;
    private static final QuitCommand quitCommand = new QuitCommand();
    private Command currentCommand;

    public Menu(List<Command> commands, UserInput userInput) {
        this.commands = commands;
        this.userInput = userInput;
        this.commands.add(quitCommand);
        currentCommand = quitCommand;

    }

    private Command chooseCommand() throws IOException {
        String prompt = "\n\nPlease enter the number of the option you choose\n" + options();
        String optionNumberAsString = userInput.input(prompt);
        return commands.get(parseInt(optionNumberAsString) - 1);
    }

    private String options() {
        String options = "";
        int commandNumber = 1;
        for (Command command : commands){
            options += commandNumber++ + ") " + command.name() + "\n";
        }
        return options;
    }

    public void executeCurrentCommand() {
        currentCommand.execute();
    }

    public boolean userDone() {
        return currentCommand.equals(quitCommand);
    }

    public void chooseOption() throws IOException {
        currentCommand = chooseCommand();
    }
}
