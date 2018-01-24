package database.table;

import database.Database;
import database.table.row.StoragePlace;
import database.table.row.TableRow;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StoragePlaces implements Table {
    @Override
    public ArrayList<TableRow> toList(Database database, ResultSet r) throws SQLException {
        ArrayList<TableRow> storagePlaces = new ArrayList<>();
        while (r.next())
            storagePlaces.add(
                    new StoragePlace(r.getInt("id"), r.getString("name"))
            );
        return storagePlaces;
    }
}
