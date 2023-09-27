package com.accenture.mortalcommand.fightscheduleapp;

import com.accenture.mortalcommand.fightscheduleapp.commands.*;
import com.accenture.mortalcommand.fightscheduleapp.exception.CommandoException;
import com.accenture.mortalcommand.fightscheduleapp.exception.DataBaseException;
import com.accenture.mortalcommand.fightscheduleapp.fights.Fight;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 *
 *
 */
public class App {

    public void run() {

        Connector connector = new Connector();
        Connection connection = null;
        try {
            connection = connector.getConnection();
        } catch (SQLException e) {
            throw new DataBaseException("Something went wrong!", e);
        }

        Scanner scanner = new Scanner(System.in);

        // Data Storage
        List<Fight> fights = new ArrayList<>();
        List<Command> commands = createCommands(connection, scanner, fights);

        System.out.println("Welcome to the fight schedule app - The best way to have an overview about upcoming fights :)");
        boolean shouldRun = true;
        while(shouldRun) {
            System.out.println("What do you wanna do?");
            System.out.println("?>");
            String userCommand = scanner.nextLine();

            try {
                for (Command command : commands) {
                    if (command.shouldExecute(userCommand)) {
                        shouldRun = command.execute();
                    }
                }
            } catch (CommandoException e) {
                System.err.println("something went wrong!");
                e.printStackTrace();
            }


        }
    }

    private List<Command> createCommands(Connection connection, Scanner scanner, List<Fight> fights) {
        List<Command> commands = new ArrayList<>();
        Command addCommand = new AddCommand(connection, fights, scanner);
        Command showCommand = new ShowCommand(connection);
        Command removeCommand = new RemoveCommand(connection, scanner);
        Command exitCommand = new ExitCommand();

        commands.add(addCommand);
        commands.add(showCommand);
        commands.add(removeCommand);
        commands.add(exitCommand);
        return commands;
    }

    public static void main(String[] args) {
        new App().run();
    }
}
