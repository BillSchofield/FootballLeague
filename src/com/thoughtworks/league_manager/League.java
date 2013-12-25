package com.thoughtworks.league_manager;

import java.io.PrintStream;
import java.util.List;

public class League {
    private PrintStream printStream;
    private List<Player> players;

    public League(PrintStream printStream, List<Player> players) {
        this.printStream = printStream;
        this.players = players;
    }

    public void listPlayers() {
        System.out.println("All Players in League");
        for (Player player : players) {
            printStream.println(player);
        }
    }
}
