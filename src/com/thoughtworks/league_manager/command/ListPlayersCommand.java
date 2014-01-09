package com.thoughtworks.league_manager.command;

import com.thoughtworks.league_manager.model.League;

public class ListPlayersCommand implements Command {
    private League league;

    public ListPlayersCommand(League league) {
        this.league = league;
    }

    @Override
    public void execute() {
        league.listPlayers();
    }

    @Override
    public String name(){
        return "List Players";
    }
}
