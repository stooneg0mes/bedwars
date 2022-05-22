package net.stonegomes.commons.storage.impl;

import net.stonegomes.commons.storage.SqlCredentials;
import net.stonegomes.commons.storage.SqlStorage;
import org.bukkit.Bukkit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLStorage extends SqlStorage {

    private Connection connection;

    @Override
    public boolean startConnection(SqlCredentials sqlCredentials) {
        String url = "jdbc:mysql://" + sqlCredentials.getHost() + "/" + sqlCredentials.getDatabase();

        try {
            connection = DriverManager.getConnection(url, sqlCredentials.getUser(), sqlCredentials.getPassword());
            sqlCredentials.getTableCreation().accept(this);
            return true;
        } catch (SQLException exception) {
            Bukkit.getConsoleSender().sendMessage("Something bad happened on mysql connection: " + exception.getMessage());
            return false;
        }
    }


    @Override
    public boolean hasConnection() {
        return connection != null;
    }

    @Override
    public Connection getConnection() {
        return connection;
    }

}