package com.accenture.mortalcommand.fightscheduleapp.commands;

public interface Command {
    boolean execute();

    boolean shouldExecute(String commandName);
}
