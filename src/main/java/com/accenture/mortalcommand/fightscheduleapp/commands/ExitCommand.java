package com.accenture.mortalcommand.fightscheduleapp.commands;

import com.accenture.mortalcommand.fightscheduleapp.exception.DataBaseException;

import java.sql.Connection;
import java.sql.SQLException;

public class ExitCommand implements Command {
    private Connection connection;
    @Override
    public boolean execute() {
        System.out.println("Good bye.");
        try {
            connection.close();
        } catch (SQLException e) {
            throw new DataBaseException("Could not close exception!", e);
        }
        return false;
    }

    @Override
    public boolean shouldExecute(String commandName) {
        return "exit".equals(commandName);
    }
}
