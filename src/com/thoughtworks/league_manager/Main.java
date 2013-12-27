package com.thoughtworks.league_manager;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class Main {

    public static void main(String[] args) {
        List<Player> players = leaguePlayers();
        League league = new League(System.out, players);
        ListPlayersCommand listPlayersCommand = new ListPlayersCommand(league);
        Menu menu = new Menu(listPlayersCommand);
        Command command = menu.userOption();
        command.execute();
    }

    private static List<Player> leaguePlayers() {
        List<Player> players = new ArrayList<Player>();
        Player[] arrayOfPlayers = {
                new Player("Bill", "Michigan", "14", "21"),
                new Player("Pat", "Michigan", "7", "20")
        };
        players.addAll(asList(arrayOfPlayers));
        return players;
    }
}
