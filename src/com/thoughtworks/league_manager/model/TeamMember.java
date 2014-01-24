package com.thoughtworks.league_manager.model;

public interface TeamMember extends Comparable<TeamMember> {
    public abstract String formattedInformation();
    public boolean isOn(String team);
    public TeamMember team(String team);
    public String name();
}
