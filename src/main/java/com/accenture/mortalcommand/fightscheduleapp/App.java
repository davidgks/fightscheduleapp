package com.accenture.mortalcommand.fightscheduleapp;

import com.accenture.mortalcommand.fightscheduleapp.commands.AddCommand;
import com.accenture.mortalcommand.fightscheduleapp.commands.Command;
import com.accenture.mortalcommand.fightscheduleapp.commands.ExitCommand;
import com.accenture.mortalcommand.fightscheduleapp.commands.ShowCommand;
import com.sun.org.apache.bcel.internal.generic.ANEWARRAY;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 *
 *
 */
public class App {

    Scanner scanner = new Scanner(System.in);
    List<Command> commands = createCommands(scanner);



    public void run() {
        System.out.println("Welcome to the fight schedule app - The best way to have an overview about upcoming fights :)");
        boolean shouldRun = true;
        while(shouldRun) {
            System.out.println("What do you wanna do?");
            System.out.println("?>");
            String userCommand = scanner.nextLine();

            for (Command command : commands) {
                if (command.shouldExecute(userCommand)) {
                    shouldRun = command.execute();
                }
            }

        }
    }

    private List<Command> createCommands(Scanner scanner) {
        List<Command> commands = new ArrayList<>();
        Command addCommand = new AddCommand();
        Command showCommand = new ShowCommand();
        Command exitCommand = new ExitCommand();

        commands.add(addCommand);
        commands.add(showCommand);
        commands.add(exitCommand);
        return commands;
    }

    public static void main(String[] args) {
        new App().run();
    }
}
