package com.thoughtworks.league_manager.model;


public class Player extends LeagueMember {
    private String number;
    private String age;

    public Player(String name, String team, String number, String age) {
        super(name, team);
        this.number = number;
        this.age = age;
    }

    @Override
    public String formattedInformation(){
        return String.format("%-15s %-15s %-20s %-15s", name, team, number, age);
    }
}
