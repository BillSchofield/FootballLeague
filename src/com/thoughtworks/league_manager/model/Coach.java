package com.thoughtworks.league_manager.model;

import static java.lang.String.format;

public class Coach implements TeamMember {
    private String name;
    private String team;
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

    @Override
    public boolean isOn(String team) {
        return this.team.equals(team);
    }

    @Override
    public void team(String team) {
        this.team = team;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public int compareTo(TeamMember other) {
        return name().compareTo(other.name());
    }
}
