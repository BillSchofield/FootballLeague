package com.thoughtworks.league_manager.command;

import com.thoughtworks.league_manager.menu.UserInput;
import com.thoughtworks.league_manager.model.League;

public class TradePlayerCommand implements Command {
    private final UserInput userInput;
    private final League league;

    public TradePlayerCommand(UserInput userInput, League league) {
        this.userInput = userInput;
        this.league = league;
    }

    @Override
    public void execute() {
        String playerName = userInput.input("Enter the name of the player to trade:");
        String newTeam = userInput.input("Enter the name of the player's new team:");
        league.tradePlayer(playerName, newTeam);
        league.displayPlayer(playerName);
    }

    @Override
    public String name() {
        return "Trade Player";
    }
}
