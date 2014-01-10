package com.thoughtworks.league_manager.model;


public class Player extends TeamMember {
    private String name;
    private String number;
    private String age;

    public Player(String name, String team, String number, String age) {
        super(team);
        this.name = name;
        this.number = number;
        this.age = age;
    }

    @Override
    public String formattedInformation(){
        return String.format("%-15s %-15s %-20s %-15s", name, team, number, age);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;

        Player player = (Player) o;

        if (!name.equals(player.name)) return false;
        if (!number.equals(player.number)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + number.hashCode();
        return result;
    }
}
