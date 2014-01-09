package com.thoughtworks.league_manager.model;

public abstract class LeagueMember {
    protected final String name;
    protected String team;

    protected LeagueMember(String name, String team) {
        this.name = name;
        this.team = team;
    }

    public abstract String formattedInformation();

    public boolean hasName(String name) {
        return this.name.equals(name);
    }

    boolean isOn(String team){
        return this.team.equals(team);
    }
}
