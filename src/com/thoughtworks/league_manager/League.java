package com.thoughtworks.league_manager;

import java.io.PrintStream;
import java.util.List;

import static java.lang.String.format;

public class League {
    private PrintStream printStream;
    private List<Player> players;

    public League(PrintStream printStream, List<Player> players) {
        this.printStream = printStream;
        this.players = players;
    }

    public void listPlayers() {
        printStream.println("All Players in League");
        printStream.println(format("%-15s %-15s %-15s %-15s", "Name", "Team", "Number", "Age"));
        for (Player player : players) {
            printStream.println(player);
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
}
