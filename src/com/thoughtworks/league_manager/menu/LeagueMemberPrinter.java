package com.thoughtworks.league_manager.menu;

import com.thoughtworks.league_manager.model.LeagueMember;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

public class LeagueMemberPrinter {
    private PrintStream printStream;

    public LeagueMemberPrinter(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void print(String title, List<LeagueMember> members) {
        printStream.println(title);
        printStream.println(format("%-15s %-15s %-20s %-15s", "Name", "Team", "Number/Title", "Age"));
        for (LeagueMember leagueMember : members) {
            printStream.println(leagueMember.formattedInformation());
        }
    }

    public void print(String title, LeagueMember member) {
        List<LeagueMember> members = new ArrayList<LeagueMember>();
        members.add(member);
        print(title, members);
    }
}
