package com.thoughtworks.league_manager.model;

import com.thoughtworks.league_manager.menu.LeagueMemberPrinter;

import java.util.ArrayList;
import java.util.List;

public class League {
    private static final LeagueMember nullPlayer = new LeagueMember("", "") {
        @Override
        public String formattedInformation() {
            return "Player not found.";
        }
    };

    private List<Player> players;
    private List<Coach> coaches;
    private LeagueMemberPrinter leagueMemberPrinter;

    public League(LeagueMemberPrinter leagueMemberPrinter, List<Player> players, List<Coach> coaches) {
        this.leagueMemberPrinter = leagueMemberPrinter;
        this.players = players;
        this.coaches = coaches;
    }

    public void listPlayers() {
        List<LeagueMember> leagueMembers = new ArrayList<LeagueMember>();
        leagueMembers.addAll(players);
        leagueMembers.addAll(coaches);
        leagueMemberPrinter.print("All Members in League", leagueMembers);
    }

    private LeagueMember findPlayer(String name, LeagueMember defaultReturn) {
        for (Player player : players) {
            if (player.hasName(name)){
                return player;
            }
        }
        return defaultReturn;
    }

    private List<LeagueMember> team(String teamName) {
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

    public void displayPlayer(String playerName) {
        LeagueMember player = findPlayer(playerName, nullPlayer);
        if (player != nullPlayer){
            leagueMemberPrinter.print("", player);
        }
    }

    public void displayTeam(String teamName) {
        List<LeagueMember> teamMembers = team(teamName);
        String title = "Team Members of " + teamName;
        leagueMemberPrinter.print(title, teamMembers);
    }

    public void tradePlayer(String playerName, String newTeam) {
        LeagueMember player = findPlayer(playerName, nullPlayer);
        player.setTeam(newTeam);
    }
}
