package com.torben.template.utils;

import com.torben.template.Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private Main main;

    private final String HOST = main.getDatabaseConfig().getString("database.host");
    private final int PORT = main.getDatabaseConfig().getInt("database.port");
    private final String DATABASE = main.getDatabaseConfig().getString("database.database-name");
    private final String USERNAME = main.getDatabaseConfig().getString("database.username");
    private final String PASSWORD = main.getDatabaseConfig().getString("database.password");

    private Connection connection;

    public void connect() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE + "?useSSL=false",
                USERNAME,
                PASSWORD);
    }

    public boolean isConnected(){ return connection != null; }

    public Connection getConnection() { return connection; }

    public void disconnect(){
        if(isConnected()){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}