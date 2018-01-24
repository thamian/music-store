package database.table;

import database.Database;
import database.table.row.ItemCondition;
import database.table.row.TableRow;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemConditions implements Table {
    @Override
    public ArrayList<TableRow> toList(Database database, ResultSet r) throws SQLException {
        ArrayList<TableRow> itemConditions = new ArrayList<>();
        while (r.next())
            itemConditions.add(
                    new ItemCondition(r.getInt("id"), r.getString("name"))
            );
        return itemConditions;
    }
}
