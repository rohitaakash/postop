package com.postop.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {
    private static Connection connection = null;

    public static Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            if (connection == null) {
                connection = DriverManager.getConnection("jdbc:postgresql://stampy.db.elephantsql.com:5432/vudpsbvv", "vudpsbvv", "AhyUgFaUYXYm1byR97ZJn4Gd9Foej16Y");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static boolean closeConnection() {
        try {
            if (connection != null) {
                connection.close();
                connection = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}

