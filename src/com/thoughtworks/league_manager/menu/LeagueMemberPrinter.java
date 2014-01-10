package com.thoughtworks.league_manager.menu;

import com.thoughtworks.league_manager.model.TeamMember;

import java.io.PrintStream;
import java.util.HashSet;
import java.util.Set;

import static java.lang.String.format;

public class LeagueMemberPrinter {
    private PrintStream printStream;

    public LeagueMemberPrinter(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void print(String title, Set<TeamMember> members) {
        printStream.println(title);
        printStream.println(format("%-15s %-15s %-20s %-15s", "Name", "Team", "Number/Title", "Age"));
        for (TeamMember teamMember : members) {
            printStream.println(teamMember.formattedInformation());
        }
    }

    public void print(String title, TeamMember member) {
        Set<TeamMember> members = new HashSet<TeamMember>();
        members.add(member);
        print(title, members);
    }
}
