package com.thoughtworks.league_manager.command;

import com.thoughtworks.league_manager.menu.UserInput;
import com.thoughtworks.league_manager.model.League;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindPlayerCommand implements Command {
    private League league;
    private UserInput userInput;

    @Autowired
    public FindPlayerCommand(UserInput userInput, League league) {
        this.userInput = userInput;
        this.league = league;
    }

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
