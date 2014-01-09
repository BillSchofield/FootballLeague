package com.thoughtworks.league_manager.model;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

public class League {
    private PrintStream printStream;
    private List<Player> players;
    private List<Coach> coaches;

    public League(PrintStream printStream, List<Player> players, List<Coach> coaches) {
        this.printStream = printStream;
        this.players = players;
        this.coaches = coaches;
    }

    public void listPlayers() {
        List<LeagueMember> leagueMembers = new ArrayList<LeagueMember>();
        leagueMembers.addAll(players);
        leagueMembers.addAll(coaches);
        printStream.println("All Members in League");
        printStream.println(format("%-15s %-15s %-20s %-15s", "Name", "Team", "Number/Title", "Age"));
        for (LeagueMember leagueMember : leagueMembers) {
            printStream.println(leagueMember.formattedInformation());
        }
    }

    public Player findPlayer(String name) {
        for (Player player : players) {
            if (player.hasName(name)){
                return player;
            }
        }
        return null;
    }

    public List<LeagueMember> team(String teamName) {
        List<LeagueMember> team = new ArrayList<LeagueMember>();
        for (LeagueMember player : players) {
            if (player.isOn(teamName)){
                team.add(player);
            }
        }
        for (LeagueMember coach : coaches) {
            if (coach.isOn(teamName)){
                team.add(coach);
            }
        }
        return team;
    }
}
