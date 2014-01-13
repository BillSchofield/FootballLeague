package com.thoughtworks.league_manager.command;

import org.springframework.stereotype.Component;

@Component
public class QuitCommand implements Command {
    @Override
    public void execute() {

    }

    @Override
    public String name() {
        return "Quit";
    }
}
