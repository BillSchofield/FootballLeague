package com.thoughtworks.league_manager.command;

import com.thoughtworks.league_manager.menu.UserInput;
import com.thoughtworks.league_manager.model.League;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TradePlayerCommand implements Command {
    private final UserInput userInput;
    private final League league;

    @Override
    public void execute() {
        String playerName = userInput.input("Enter the player's name:");
        String playerNumber = userInput.input("Enter the player's number:");
        String newTeam = userInput.input("Enter the name of the player's new team:");
        league.tradePlayer(playerName, playerNumber, newTeam);
        league.displayPlayer(playerName, playerNumber);
    }

    @Override
    public String name() {
        return "Trade Player";
    }
}
