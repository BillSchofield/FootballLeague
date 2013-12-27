package com.thoughtworks.league_manager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class FindPlayerCommand implements Command {
    private PrintStream printStream;
    private BufferedReader bufferedReader;
    private League league;

    public FindPlayerCommand(PrintStream printStream, BufferedReader bufferedReader, League league) {
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
        this.league = league;
    }

    @Override
    public void execute() {
        printStream.println("Enter the name of the player to find:");
        String playerName;
        try {
            playerName = bufferedReader.readLine();
        } catch (IOException e) {
            throw new UncheckedIOException();
        }

        Player foundPlayer = league.findPlayer(playerName);
        if (foundPlayer != null){
            printStream.println(foundPlayer.toString());
        }
        else {
            printStream.println("Player not found in League.");
        }
    }

    @Override
    public String name() {
        return "Find Player by Name";
    }
}
