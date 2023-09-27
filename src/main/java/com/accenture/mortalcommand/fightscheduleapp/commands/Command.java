package com.accenture.mortalcommand.fightscheduleapp.commands;

import com.accenture.mortalcommand.fightscheduleapp.exception.CommandoException;

import java.sql.SQLException;

public interface Command {
    boolean execute() throws CommandoException;

    boolean shouldExecute(String commandName);
}
