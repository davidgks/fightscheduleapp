package com.accenture.mortalcommand.fightscheduleapp.commands;

public class ExitCommand implements Command {
    @Override
    public boolean execute() {
        System.out.println("Good bye.");
        return false;
    }

    @Override
    public boolean shouldExecute(String commandName) {
        return "exit".equals(commandName);
    }
}
