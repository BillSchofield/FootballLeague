package com.thoughtworks.league_manager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

public class DisplayTeamCommand implements Command {
    private final PrintStream printStream;
    private final BufferedReader bufferedReader;
    private final League league;

    public DisplayTeamCommand(PrintStream printStream, BufferedReader bufferedReader, League league) {
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
        this.league = league;
    }

    @Override
    public void execute() {
        printStream.println("Enter the name of the team to display:");
        String teamName;
        try {
            teamName = bufferedReader.readLine();
        } catch (IOException e) {
            throw new UncheckedIOException();
        }

        List<LeagueMember> teamMembers = league.team(teamName);
        new LeagueMemberPrinter(printStream, "Team Members of " + teamName).print(teamMembers);
    }

    @Override
    public String name() {
        return "Display Team";
    }
}
