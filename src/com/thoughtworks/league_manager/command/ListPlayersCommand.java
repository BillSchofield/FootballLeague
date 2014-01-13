package com.thoughtworks.league_manager.command;

import com.thoughtworks.league_manager.model.League;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ListPlayersCommand implements Command {
    private League league;

    @Override
    public void execute() {
        league.listPlayers();
    }

    @Override
    public String name(){
        return "List Players";
    }
}
