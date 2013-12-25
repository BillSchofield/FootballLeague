package com.thoughtworks.league_manager;

import static java.lang.String.format;

public class Player {
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
    public String toString(){
        return format("%-15s %-15s %-15s %-15s", name, team, number, age);
    }
}
