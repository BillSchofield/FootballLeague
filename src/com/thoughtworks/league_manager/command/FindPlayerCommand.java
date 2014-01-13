package com.thoughtworks.league_manager.command;

import com.thoughtworks.league_manager.menu.UserInput;
import com.thoughtworks.league_manager.model.League;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FindPlayerCommand implements Command {
    private UserInput userInput;
    private League league;

    @Override
    public void execute() {
        String playerName = userInput.input("Enter the name of the player:");
        String playerNumber = userInput.input("Enter the number of the player:");
        league.displayPlayer(playerName, playerNumber);
    }

    @Override
    public String name() {
        return "Find Player by Name and Number";
    }
}
