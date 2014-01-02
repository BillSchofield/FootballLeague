package com.thoughtworks.league_manager;

import java.io.PrintStream;

public class FindPlayerCommand implements Command {
    private PrintStream printStream;
    private League league;
    private UserInput userInput;

    public FindPlayerCommand(PrintStream printStream, UserInput userInput, League league) {
        this.printStream = printStream;
        this.userInput = userInput;
        this.league = league;
    }

    @Override
    public void execute() {
        String playerName = userInput.input("Enter the name of the player to find:");

        Player foundPlayer = league.findPlayer(playerName);
        if (foundPlayer != null){
            printStream.println(foundPlayer.formattedInformation());
        }
        else {
            printStream.println("Player not found in League.");
        }
    }

    @Override
    public String name() {
        return "Find Player by Name";
    }
}
