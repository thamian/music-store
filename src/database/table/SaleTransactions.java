package database.table;

import database.Database;
import database.table.row.SaleTransaction;
import database.table.row.TableRow;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SaleTransactions implements Table {
    @Override
    public ArrayList<TableRow> toList(Database database, ResultSet r) throws SQLException {
        ArrayList<TableRow> purchaseTransactions = new ArrayList<>();
        while (r.next())
            purchaseTransactions.add(
                    new SaleTransaction.Builder(r.getInt("id"))
                            .clientId(r.getInt("client_id"))
                            .transactionStatusId(r.getInt("transaction_status_id"))
                            .date(r.getString("date"))
                            .build());
        return purchaseTransactions;
    }
}
