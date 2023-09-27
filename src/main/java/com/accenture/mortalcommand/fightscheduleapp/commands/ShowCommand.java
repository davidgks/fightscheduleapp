package com.accenture.mortalcommand.fightscheduleapp.commands;

import com.accenture.mortalcommand.fightscheduleapp.exception.CommandoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class ShowCommand implements Command {

    private Connection connection;

    public ShowCommand (Connection connection) {
        this.connection = connection;
    }
    @Override
    public boolean execute() throws CommandoException {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "select fighter1_id, fighter2_id, location_id, division_id from fights"
            );
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int fighter1_id = resultSet.getInt("fighter1_id");
                int fighter2_id = resultSet.getInt("fighter2_id");
                int location_id = resultSet.getInt("location_id");
                int division_id = resultSet.getInt("division_id");

                System.out.println("fighter 1: " + fighter1_id + " fighter 2: " + fighter2_id + " location: " + location_id + " weightclass: " + division_id);
            }
            return true;
        } catch (SQLException e) {
            throw new CommandoException("Commando exception thrown!");
        }
    }

    @Override
    public boolean shouldExecute(String commandName) {
        return "show".equals(commandName);
    }
}
