package com.thoughtworks.league_manager;

import static java.lang.String.format;

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
        return format("%-15s %-15s %-20s %-15s", name, team, number, age);
    }
}
