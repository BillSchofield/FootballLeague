package com.thoughtworks.league_manager.command;

import com.thoughtworks.league_manager.model.League;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor(onConstructor=@_(@Autowired))
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
