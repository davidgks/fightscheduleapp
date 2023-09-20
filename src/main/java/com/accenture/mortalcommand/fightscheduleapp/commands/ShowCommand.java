package com.accenture.mortalcommand.fightscheduleapp.commands;

public class ShowCommand implements Command {
    @Override
    public boolean execute() {
        return false;
    }

    @Override
    public boolean shouldExecute(String commandName) {
        return "show".equals(commandName);
    }
}
