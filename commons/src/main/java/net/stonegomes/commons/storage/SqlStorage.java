package net.stonegomes.commons.storage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.stonegomes.commons.storage.query.Query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@AllArgsConstructor
@Getter
public abstract class SqlStorage {

    public ResultSet executeQuery(Query query) {
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(query.getQueryContent());

            if (query.getValues() != null) {
                for (int i = 0; i < query.getValues().length; i++) {
                    preparedStatement.setObject(i + 1, query.getValues()[i]);
                }
            }

            if (query.getQueryContent().toLowerCase().contains("select")) return preparedStatement.executeQuery();
            else preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return null;
    }

    public abstract boolean startConnection(SqlCredentials sqlCredentials);

    public abstract boolean hasConnection();

    public abstract Connection getConnection();

}