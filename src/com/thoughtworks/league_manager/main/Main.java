package com.thoughtworks.league_manager.main;

import com.thoughtworks.league_manager.command.*;
import com.thoughtworks.league_manager.menu.LeagueMemberPrinter;
import com.thoughtworks.league_manager.menu.Menu;
import com.thoughtworks.league_manager.menu.UserInput;
import com.thoughtworks.league_manager.model.Coach;
import com.thoughtworks.league_manager.model.League;
import com.thoughtworks.league_manager.model.Player;

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
        UserInput userInput = new UserInput(printStream, bufferedReader);

        List<Player> players = leaguePlayers();
        List<Coach> coaches = leagueCoaches();
        LeagueMemberPrinter leagueMemberPrinter = new LeagueMemberPrinter(printStream);
        League league = new League(leagueMemberPrinter, players, coaches);

        List<Command> commands = createCommands(userInput, league);

        Menu menu = new Menu(commands, userInput);
        menu.chooseOption();
        while (!menu.userDone()){
            menu.executeCurrentCommand();
            menu.chooseOption();
        }
    }

    private static  List<Command> createCommands(UserInput userInput, League league) {
        List<Command> commands = new ArrayList<Command>();
        commands.add(new ListPlayersCommand(league));
        commands.add(new FindPlayerCommand(userInput, league));
        commands.add(new DisplayTeamCommand(userInput, league));
        commands.add(new TradePlayerCommand(userInput, league));
        return commands;
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
