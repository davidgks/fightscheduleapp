package com.accenture.mortalcommand.fightscheduleapp.exception;

import java.sql.SQLException;

public class CommandoException extends Exception {
    public CommandoException(String message) {
        super(message);
    }

    public CommandoException(String message, Throwable cause) {
        super(message, cause);
    }
}
