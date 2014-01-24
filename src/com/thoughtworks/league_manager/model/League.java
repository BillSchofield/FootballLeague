package com.thoughtworks.league_manager.model;

import com.thoughtworks.league_manager.menu.LeagueMemberPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.*;
import lombok.AllArgsConstructor;

import java.util.*;


@AllArgsConstructor(onConstructor=@_(@Autowired))
@Component
public class League {
    private static final TeamMember nullPlayer = new TeamMember() {
        @Override
        public String formattedInformation() {
            return "Player not found.";
        }

        @Override
        public boolean isOn(String team) {
            return false;
        }

        @Override
        public TeamMember team(String team) {
            return this;
        }

        @Override
        public String name() {
            return "";
        }

        @Override
        public int compareTo(TeamMember o) {
            return 0;
        }
    };

    private LeagueMemberPrinter leagueMemberPrinter;
    private Set<Player> players;
    private Set<Coach> coaches;

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
        } else {
            leagueMemberPrinter.playerNotFound(name, number);
        }
    }

    public void displayTeam(String teamName) {
        Set<TeamMember> teamMembers = team(teamName);
        String title = "Team Members of " + teamName;
        leagueMemberPrinter.print(title, teamMembers);
    }

    public void tradePlayer(String name, String number, String newTeam) {
        TeamMember player = findPlayer(name, number, nullPlayer);
        player.team(newTeam);
    }
}
