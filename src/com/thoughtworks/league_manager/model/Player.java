package com.thoughtworks.league_manager.model;


public class Player implements TeamMember {
    private String name;
    private String team;
    private String number;
    private String age;

    public Player(String name, String team, String number, String age) {
        this.name = name;
        this.team = team;
        this.number = number;
        this.age = age;
    }

    @Override
    public String formattedInformation(){
        return String.format("%-15s %-15s %-20s %-15s", name, team, number, age);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Player)) {
            return false;
        }

        Player player = (Player) o;

        if (!name.equals(player.name)) {
            return false;
        }
        return number.equals(player.number);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + number.hashCode();
        return result;
    }

    @Override
    public boolean isOn(String team) {
        return this.team.equals(team);
    }

    @Override
    public void setTeam(String team) {

        this.team = team;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int compareTo(TeamMember other) {
        return getName().compareTo(other.getName());
    }
}
