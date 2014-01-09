package com.thoughtworks.league_manager.command;

import com.thoughtworks.league_manager.model.League;
import com.thoughtworks.league_manager.model.LeagueMember;
import com.thoughtworks.league_manager.menu.LeagueMemberPrinter;
import com.thoughtworks.league_manager.menu.UserInput;

import java.io.PrintStream;
import java.util.List;

public class DisplayTeamCommand implements Command {
    private final PrintStream printStream;
    private final UserInput userInput;
    private final League league;

    public DisplayTeamCommand(PrintStream printStream, UserInput userInput, League league) {
        this.printStream = printStream;
        this.userInput = userInput;
        this.league = league;
    }

    @Override
    public void execute() {
        String teamName = userInput.input("Enter the name of the team to display:");
        List<LeagueMember> teamMembers = league.team(teamName);
        new LeagueMemberPrinter(printStream, "Team Members of " + teamName).print(teamMembers);
    }

    @Override
    public String name() {
        return "Display Team";
    }
}
