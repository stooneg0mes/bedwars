package net.stonegomes.commons.storage;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.io.File;
import java.util.function.Consumer;

@AllArgsConstructor
@Builder
@Getter
public class SqlCredentials {

    /*
    MySQLStorage
     */

    /**
     *
     */
    private final String host;


    private final String password;
    private final String database;
    private final String user;

    /*
    SQLiteStorage
     */

    private final String fileName;
    private final File parent;

    /*
    Table creation
     */

    private final Consumer<SqlStorage> tableCreation;

}
