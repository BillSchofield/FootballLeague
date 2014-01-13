package com.thoughtworks.league_manager.model;

public interface TeamMember extends Comparable<TeamMember> {
    public abstract String formattedInformation();
    public boolean isOn(String team);
    public void setTeam(String team);
    public String getName();
}
