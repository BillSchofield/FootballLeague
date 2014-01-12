package com.thoughtworks.league_manager.model;

public abstract class TeamMember implements Comparable<TeamMember> {
    protected String name;
    protected String team;

    public abstract String formattedInformation();

    protected TeamMember(String name, String team) {
        this.name = name;
        this.team = team;
    }

    public boolean isOn(String team){
        return this.team.equals(team);
    }

    public void setTeam(String team){
        this.team = team;
    }

    @Override
    public int compareTo(TeamMember other) {
        return name.compareTo(other.name);
    }

}
