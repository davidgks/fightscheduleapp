package com.accenture.mortalcommand.fightscheduleapp.commands;

import com.accenture.mortalcommand.fightscheduleapp.exception.CommandoException;
import com.accenture.mortalcommand.fightscheduleapp.fights.Fight;
import com.accenture.mortalcommand.fightscheduleapp.utility.DateUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class AddCommand implements Command {

    private Connection connection;
    private List<Fight> fights;
    private Scanner scanner;

    public AddCommand(Connection connection, List<Fight> fights, Scanner scanner) {
        this.connection = connection;
        this.fights = fights;
        this.scanner = scanner;
    }

    @Override
    public boolean execute() throws CommandoException {
        try {
            System.out.println("Location id?");
            int location_id = Integer.parseInt(scanner.nextLine());

            System.out.println("What time and date is the event going to happen?");
            System.out.println("----- Input format: 2018-10-28T15:23:01");
            String playtimeString = scanner.nextLine();
            LocalDateTime playtime = DateUtil.parseDateTime(playtimeString);

            System.out.println("Id of fighter 1: ");
            int fighter1_id = Integer.parseInt(scanner.nextLine());

            System.out.println("If of fighter 2: ");
            int fighter2_id = Integer.parseInt(scanner.nextLine());

            System.out.println("division id: ");
            int division_id = Integer.parseInt(scanner.nextLine());

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "insert into fights (location_id, showtime, fighter1_id, fighter2_id, division_id) values (?, ?, ?, ?, ?)"
            );
            preparedStatement.setInt(1, location_id);
            preparedStatement.setObject(2, playtime);
            preparedStatement.setInt(3, fighter1_id);
            preparedStatement.setInt(4, fighter2_id);
            preparedStatement.setInt(5, division_id);

            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            throw new CommandoException("Commando exception thrown!", e);
        }


    }

    @Override
    public boolean shouldExecute(String commandName) {
        return "add".equals(commandName);
    }
}
