package com.thoughtworks.league_manager.command;

public interface Command {
    void execute();

    String name();
}
