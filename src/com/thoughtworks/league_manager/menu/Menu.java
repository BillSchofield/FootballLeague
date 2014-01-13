package com.thoughtworks.league_manager.menu;

import com.thoughtworks.league_manager.command.Command;
import lombok.AllArgsConstructor;

import java.io.IOException;
import java.util.List;

import static java.lang.Integer.parseInt;

@AllArgsConstructor
public class Menu {
    private List<Command> commands;
    private UserInput userInput;
    private final Command quitCommand;
    private Command currentCommand;

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
