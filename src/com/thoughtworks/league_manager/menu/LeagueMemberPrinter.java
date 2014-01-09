package com.thoughtworks.league_manager.menu;

import com.thoughtworks.league_manager.model.LeagueMember;

import java.io.PrintStream;
import java.util.List;

import static java.lang.String.format;

public class LeagueMemberPrinter {
    private PrintStream printStream;
    private String title;

    public LeagueMemberPrinter(PrintStream printStream, String title) {
        this.printStream = printStream;
        this.title = title;
    }

    public void print(List<LeagueMember> members) {
        printStream.println(title);
        printStream.println(format("%-15s %-15s %-20s %-15s", "Name", "Team", "Number/Title", "Age"));
        for (LeagueMember leagueMember : members) {
            printStream.println(leagueMember.formattedInformation());
        }
    }
}
