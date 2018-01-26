package database.table;

import database.Database;
import database.table.row.Address;
import database.table.row.TableRow;
import database.table.row.TransactionStatus;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TransactionStatuses implements Table {
    @Override
    public ArrayList<TransactionStatus> toList(Database database, ResultSet r) throws SQLException {
        ArrayList<TransactionStatus> transactionStatuses = new ArrayList<>();
        while (r.next())
            transactionStatuses.add(
                    new TransactionStatus(r.getInt("id"), r.getString("name"))
            );
        return transactionStatuses;
    }
}
