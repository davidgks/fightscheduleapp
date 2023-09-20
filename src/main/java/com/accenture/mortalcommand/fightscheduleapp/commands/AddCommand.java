package com.accenture.mortalcommand.fightscheduleapp.commands;

import com.accenture.mortalcommand.fightscheduleapp.fights.Fight;

import java.util.List;
import java.util.Scanner;

public class AddCommand implements Command {

    private List<Fight> fights;
    private Scanner scanner;

    public AddCommand(List<Fight> fights, Scanner scanner) {
        this.fights = fights;
        this.scanner = scanner;
    }

    @Override
    public boolean execute() {
        return false;
    }

    @Override
    public boolean shouldExecute(String commandName) {
        return "add".equals(commandName);
    }
}
