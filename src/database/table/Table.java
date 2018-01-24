package database.table;

import database.Database;
import database.table.row.TableRow;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public interface Table {
    public default ArrayList<TableRow> selectFrom(Database database, String sql) throws SQLException {
        Statement statement  = database.connection().createStatement();
        ArrayList<TableRow> addresses = toList(database, statement.executeQuery(sql));
        return addresses;
    }

    public ArrayList<TableRow> toList(Database database, ResultSet r) throws SQLException;

    public default int count(Database database, String sql, int id) throws SQLException {
        Statement statement  = database.connection().createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        return resultSet.getInt(1);
    }
}
