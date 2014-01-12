package com.thoughtworks.league_manager.model;

import com.thoughtworks.league_manager.menu.LeagueMemberPrinter;

import java.util.*;

public class League {
    private static final TeamMember nullPlayer = new TeamMember("name", "team") {
        @Override
        public String formattedInformation() {
            return "Player not found.";
        }
    };

    private Set<Player> players;
    private Set<Coach> coaches;
    private LeagueMemberPrinter leagueMemberPrinter;

    public League(LeagueMemberPrinter leagueMemberPrinter, Set<Player> players, Set<Coach> coaches) {
        this.leagueMemberPrinter = leagueMemberPrinter;
        this.players = players;
        this.coaches = coaches;
    }

    public void listPlayers() {
        Set<TeamMember> teamMembers = new TreeSet<TeamMember>();
        teamMembers.addAll(players);
        teamMembers.addAll(coaches);
        leagueMemberPrinter.print("All Members in League", teamMembers);
    }

    private TeamMember findPlayer(String name, String number, TeamMember defaultReturn) {
        TeamMember playerToFind = new Player(name, "Team", number, "age");
        for (Player player : players) {
            if (player.equals(playerToFind)){
                return player;
            }
        }
        return defaultReturn;
    }

    private Set<TeamMember> team(String teamName) {
        Set<TeamMember> team = new HashSet<TeamMember>();
        for (TeamMember player : players) {
            if (player.isOn(teamName)){
                team.add(player);
            }
        }
        for (TeamMember coach : coaches) {
            if (coach.isOn(teamName)){
                team.add(coach);
            }
        }
        return team;
    }

    public void displayPlayer(String name, String number) {
        TeamMember player = findPlayer(name, number, nullPlayer);
        if (player != nullPlayer){
            leagueMemberPrinter.print("", player);
        }
    }

    public void displayTeam(String teamName) {
        Set<TeamMember> teamMembers = team(teamName);
        String title = "Team Members of " + teamName;
        leagueMemberPrinter.print(title, teamMembers);
    }

    public void tradePlayer(String name, String number, String newTeam) {
        TeamMember player = findPlayer(name, number, nullPlayer);
        player.setTeam(newTeam);
    }
}
