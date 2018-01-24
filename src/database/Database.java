package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    Connection connection;

    public Database(String connectionString) throws SQLException {
        connection = DriverManager.getConnection(connectionString);
    }

    public Connection connection() {
        return connection;
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }
}
