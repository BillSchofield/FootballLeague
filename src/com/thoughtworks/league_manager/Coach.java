package com.thoughtworks.league_manager;

import static java.lang.String.format;

public class Coach implements LeagueMember{
    private final String name;
    private final String team;
    private final String title;

    public Coach(String name, String team, String title) {
        this.name = name;
        this.team = team;
        this.title = title;
    }

    @Override
    public String formattedInformation() {
        return format("%-15s %-15s %-20s", name, team, title);

    }
}
