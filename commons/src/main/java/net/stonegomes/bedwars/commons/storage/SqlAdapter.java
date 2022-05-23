package net.stonegomes.bedwars.commons.storage;

import net.stonegomes.bedwars.commons.storage.query.Query;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface SqlAdapter<T> {

    T read(ResultSet resultSet) throws SQLException;

    Query buildReplaceQuery(T value);

    Query buildDeleteQuery(Object object);

}
