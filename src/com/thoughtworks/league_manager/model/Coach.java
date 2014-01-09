package com.thoughtworks.league_manager.model;

import static java.lang.String.format;

public class Coach extends LeagueMember {
    private final String title;

    public Coach(String name, String team, String title) {
        super(name, team);
        this.title = title;
    }

    @Override
    public String formattedInformation() {
        return format("%-15s %-15s %-20s", name, team, title);
    }
}
