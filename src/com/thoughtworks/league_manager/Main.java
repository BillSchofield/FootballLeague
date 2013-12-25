package com.thoughtworks.league_manager;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class Main {

    public static void main(String[] args) {
        List<Player> players = leaguePlayers();
        new League(System.out, players).listPlayers();
    }

    private static List<Player> leaguePlayers() {
        List<Player> players = new ArrayList<Player>();
        Player[] arrayOfPlayers = {
                new Player("Bill"),
                new Player("Pat")
        };
        players.addAll(asList(arrayOfPlayers));
        return players;
    }
}
