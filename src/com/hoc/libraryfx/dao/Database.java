package com.hoc.libraryfx.dao;

import org.postgresql.ds.PGPoolingDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class Database {
    private static Database instance;

    // Connections pool
    private PGPoolingDataSource source;

    private Database(String host, int port, String dbname, String username, String password) {
        PGPoolingDataSource source = new PGPoolingDataSource();
        source.setServerName(host);
        source.setPortNumber(port);
        source.setDatabaseName(dbname);
        source.setUser(username);
        source.setPassword(password);
        source.setMaxConnections(5);

        this.source = source;
    }

    public static void initialize(String host, int port, String dbname, String username, String password) {
        if (instance == null) {
            instance = new Database(host, port, dbname, username, password);
        }
    }

    static Database getInstance() {
        return instance;
    }

     Connection getConn() throws SQLException {
         return source.getConnection();
    }

    // Alternative shortcut static method
    static Connection getConnection() throws SQLException {
        return getInstance().getConn();
    }

}
