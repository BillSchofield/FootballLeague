package com.thoughtworks.league_manager.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;

import static java.lang.String.format;

@Accessors(fluent = true)
@AllArgsConstructor(onConstructor=@_(@Autowired))
public class Coach implements TeamMember {
    @Getter
    private String name;
    @Setter
    private String team;
    private final String title;

    @Override
    public String formattedInformation() {
        return format("%-15s %-15s %-20s", name, team, title);
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
