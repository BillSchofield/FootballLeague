package com.thoughtworks.league_manager.model;

public abstract class TeamMember {
    protected String team;

    protected TeamMember(String team) {
        this.team = team;
    }

    public abstract String formattedInformation();

    public boolean isOn(String team){
        return this.team.equals(team);
    }

    public void setTeam(String team) {
        this.team = team;
    }
}
