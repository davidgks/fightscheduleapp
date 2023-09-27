package com.accenture.mortalcommand.fightscheduleapp.commands;

import com.accenture.mortalcommand.fightscheduleapp.exception.CommandoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class RemoveCommand implements Command {

    private Connection connection;
    private Scanner scanner;

    public RemoveCommand (Connection connection, Scanner scanner) {
        this.connection = connection;
        this.scanner = scanner;
    }

    @Override
    public boolean execute() throws CommandoException {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "delete from fight where id = ?"
            );
            System.out.println("What fight do you wanna delete?");
            int fightID = Integer.parseInt(scanner.nextLine());
            preparedStatement.setInt(1, fightID);
            preparedStatement.execute();

            System.out.println("fight " + fightID + " deleted");
            return true;
        } catch (SQLException e) {
            throw new CommandoException("Commando exception thrown!", e);
        }

    }

    @Override
    public boolean shouldExecute(String commandName) {
        return "remove".equals(commandName);
    }
}
