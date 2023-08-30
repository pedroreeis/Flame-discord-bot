package com.pedroreis.Database.providers;

import com.pedroreis.Database.Database;

import java.sql.*;

public class MySQL implements Database {
    private Connection connection;

    @Override
    public Connection getConnection() {
        return connection;
    }
    @Override
    public void open() {
        String host = "localhost:3306";
        String user = "root";
        String password = "1234";
        String database = "discord";
        String url = "jdbc:mysql://" + host + "/" + database + "?autoReconnect=true";

        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("[BOT] Database Connection created.");
            createTable();
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.exit(0);
        }
    }

    @Override
    public void close() {
        try {
            connection.close();
            System.out.println("[BOT] Database Connection closed.");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void createTable() {
        try {
            PreparedStatement stm = this.connection.prepareStatement(
                    "create table if not exists discordbot_users(`userId` VARCHAR(18) NOT NULL, " +
                            "`userTag` TEXT NOT NULL, " +
                            "PRIMARY KEY (`userId`) USING BTREE)"
            );
            PreparedStatement stm2 = this.connection.prepareStatement(
                    "create table if not exists discordbot_guilds(`serverId` varchar(18) NOT NULL, " +
                            "`serverPrefix` varchar(5) NOT NULL, " +
                            "`serverChannel_announce` varchar(18) NOT NULL, " +
                            "`serverIdRoleAdd` varchar(18) NOT NULL, " +
                            "PRIMARY KEY (`serverId`) USING BTREE)"
            );
            stm.executeUpdate();
            stm2.executeUpdate();
            System.out.println("[BOT] Database Tables created.");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
