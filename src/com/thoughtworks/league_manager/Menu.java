package com.thoughtworks.league_manager;

public class Menu {
    private ListPlayersCommand listPlayersCommand;

    public Menu(ListPlayersCommand listPlayersCommand) {
        this.listPlayersCommand = listPlayersCommand;
    }

    public Command userOption() {
        return listPlayersCommand;
    }
}
