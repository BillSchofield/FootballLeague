package com.thoughtworks.league_manager.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;

@Accessors(fluent = true)
@EqualsAndHashCode(of={"name", "number"})
@AllArgsConstructor(onConstructor=@_(@Autowired))
public class Player implements TeamMember {
    @Getter
    private String name;
    @Setter
    private String team;
    private String number;
    private String age;

    @Override
    public String formattedInformation(){
        return String.format("%-15s %-15s %-20s %-15s", name, team, number, age);
    }

    @Override
    public boolean isOn(String team) {
        return this.team.equals(team);
    }

    @Override
    public int compareTo(TeamMember other) {
        return name().compareTo(other.name());
    }
}
