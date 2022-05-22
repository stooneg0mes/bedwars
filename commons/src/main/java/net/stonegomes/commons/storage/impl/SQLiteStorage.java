package net.stonegomes.commons.storage.impl;

import net.stonegomes.commons.storage.SqlCredentials;
import net.stonegomes.commons.storage.SqlStorage;
import org.bukkit.Bukkit;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteStorage extends SqlStorage {

    private Connection connection;

    @Override
    public boolean startConnection(SqlCredentials sqlCredentials) {
        File file;
        try {
            file = new File(sqlCredentials.getParent(), sqlCredentials.getFileName() + ".db");
            file.createNewFile();
        } catch (IOException ignored) {
            return false;
        }


        String url = "jdbc:sqlite:" + file;

        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(url);

            sqlCredentials.getTableCreation().accept(this);
            return true;
        } catch (ClassNotFoundException | SQLException exception) {
            Bukkit.getConsoleSender().sendMessage("Something bad happened on sqlite connection: " + exception.getMessage());
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
