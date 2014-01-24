package com.thoughtworks.league_manager.command;

import com.thoughtworks.league_manager.menu.UserInput;
import com.thoughtworks.league_manager.model.League;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

// Sup dawg, we heard you like annotations,
// so we put annotations in your annotations
// so you can annotate while you're annotating.

@Component
@AllArgsConstructor(onConstructor=@_(@Autowired))
public class DisplayTeamCommand implements Command {
    private final UserInput userInput;
    private final League league;

    @Override
    public void execute() {
        String teamName = userInput.input("Enter the name of the team to display:");
        league.displayTeam(teamName);
    }

    @Override
    public String name() {
        return "Display Team";
    }
}
