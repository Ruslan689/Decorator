package com.example.decorator;

import java.sql.Connection;
import java.sql.DriverManager;

import lombok.SneakyThrows;

public class DBConnection {
    @SuppressWarnings("unused")
    private static DBConnection dbConnection;

    @SuppressWarnings("unused")
    private Connection connection;

    @SneakyThrows
    private DBConnection() {
        this.connection = DriverManager.getConnection(null, null, null);
    }

    public String getDocument(String gcsPeth){
        
        return null;
    }
}
