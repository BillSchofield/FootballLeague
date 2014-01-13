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
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        PrintStream printStream = System.out;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        UserInput userInput = new UserInput(printStream, bufferedReader);

        Set<Player> players = leaguePlayers();
        Set<Coach> coaches = leagueCoaches();
        LeagueMemberPrinter leagueMemberPrinter = new LeagueMemberPrinter(printStream);
        League league = new League(leagueMemberPrinter, players, coaches);

        Command quitCommand = new QuitCommand();
        List<Command> commands = createCommands(userInput, league, quitCommand);

        Menu menu = new Menu(commands, userInput, quitCommand, quitCommand);
        menu.chooseOption();
        while (!menu.userDone()){
            menu.executeCurrentCommand();
            menu.chooseOption();
        }
    }

    private static  List<Command> createCommands(UserInput userInput, League league, Command quitCommand) {
        List<Command> commands = new ArrayList<Command>();
        commands.add(new ListPlayersCommand(league));
        commands.add(new FindPlayerCommand(userInput, league));
        commands.add(new DisplayTeamCommand(userInput, league));
        commands.add(new TradePlayerCommand(userInput, league));
        commands.add(quitCommand);
        return commands;
    }

    private static Set<Player> leaguePlayers() {
        Set<Player> players = new HashSet<Player>();
        players.add(new Player("Mary Sue", "Michigan", "7", "20"));
        players.add(new Player("Joe Bob", "Michigan", "14", "21"));
        return players;
    }

    private static Set<Coach> leagueCoaches() {
        Set<Coach> coaches = new HashSet<Coach>();
        coaches.add(new Coach("Bill", "Michigan", "Special Teams Coach"));
        coaches.add(new Coach("Pat", "Michigan", "Head Coach"));
        return coaches;
    }
}
