package com.thoughtworks.league_manager.command;

import com.thoughtworks.league_manager.model.League;
import com.thoughtworks.league_manager.model.Player;
import com.thoughtworks.league_manager.menu.UserInput;

import java.io.PrintStream;

public class TradePlayerCommand implements Command {
    private final PrintStream printStream;
    private final UserInput userInput;
    private final League league;

    public TradePlayerCommand(PrintStream printStream, UserInput userInput, League league) {
        this.printStream = printStream;
        this.userInput = userInput;
        this.league = league;
    }

    @Override
    public void execute() {
        String playerName = userInput.input("Enter the name of the player to trade:");
        Player player = league.findPlayer(playerName);
        if (player == null){
            printStream.println("Player not found.");
        }
        else {
            String newTeamName = userInput.input("Enter the player's new team:");
            player.setTeam(newTeamName);
        }

    }

    @Override
    public String name() {
        return "Trade Player";
    }
}
