package database.table.row;

import database.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface TableRow {
    public int getId();

    public default void insertInto(Database database, String sql) throws SQLException {
        prepareInsertStatement(database.connection(), sql)
                .executeUpdate();
    }

    public default void updateIn(Database database, String sql) throws SQLException {
        prepareUpdateStatement(database.connection(), sql)
                .executeUpdate();
    }

    public default void deleteFrom(Database database, String sql) throws SQLException {
        prepareDeleteStatement(database.connection(), sql)
                .executeUpdate();
    }

    public PreparedStatement prepareInsertStatement(Connection connection, String sql) throws SQLException;

    public PreparedStatement prepareUpdateStatement(Connection connection, String sql) throws SQLException;

    public default PreparedStatement prepareDeleteStatement(Connection connection, String sql) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, getId());
        return preparedStatement;
    }
}
