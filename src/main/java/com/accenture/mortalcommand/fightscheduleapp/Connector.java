package com.accenture.mortalcommand.fightscheduleapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.Properties;

public class Connector {
    public Connection getConnection() throws SQLException {
        Properties connectionProperties = new Properties();
        connectionProperties.put("user", "root");
        // !!!!!!!!!! Never store password in code
        connectionProperties.put("password", "secret");

        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/fightschedule", connectionProperties
        );
        System.out.println("Connected to database");
        return conn;
    }
}
