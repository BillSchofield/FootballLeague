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
        PrintStream printStream = System.out;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Player> players = leaguePlayers();
        List<Coach> coaches = leagueCoaches();
        League league = new League(printStream, players, coaches);

        List<Command> commands = new ArrayList<Command>();
        commands.add(new ListPlayersCommand(league));
        commands.add(new FindPlayerCommand(printStream, bufferedReader, league));
        commands.add(new DisplayTeamCommand(printStream, bufferedReader, league));

        Menu menu = new Menu(printStream, bufferedReader, commands);
        Command command = menu.userOption();
        command.execute();
    }

    private static List<Player> leaguePlayers() {
        List<Player> players = new ArrayList<Player>();
        Player[] arrayOfPlayers = {
                new Player("Joe Bob", "Michigan", "14", "21"),
                new Player("Mary Sue", "Michigan", "7", "20")
        };
        players.addAll(asList(arrayOfPlayers));
        return players;
    }

    private static List<Coach> leagueCoaches() {
        List<Coach> coaches = new ArrayList<Coach>();
        Coach[] arrayOfCoaches = {
                new Coach("Bill", "Michigan", "Special Teams Coach"),
                new Coach("Pat", "Michigan", "Head Coach")
        };
        coaches.addAll(asList(arrayOfCoaches));
        return coaches;
    }
}
