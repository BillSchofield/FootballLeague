package com.thoughtworks.league_manager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class Main {

    public static void main(String[] args) throws IOException {
        List<Player> players = leaguePlayers();
        PrintStream printStream = System.out;
        League league = new League(printStream, players);

        List<Command> commands = new ArrayList<Command>();
        commands.add(new ListPlayersCommand(league));

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Menu menu = new Menu(printStream, bufferedReader, commands);
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
