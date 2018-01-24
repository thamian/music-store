package database.table;

import database.Database;
import database.table.row.PurchaseTransaction;
import database.table.row.TableRow;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PurchaseTransactions implements Table {
    @Override
    public ArrayList<TableRow> toList(Database database, ResultSet r) throws SQLException {
        ArrayList<TableRow> purchaseTransactions = new ArrayList<>();
        while (r.next())
            purchaseTransactions.add(
                    new PurchaseTransaction.Builder(r.getInt("id"))
                            .vendorId(r.getInt("vendor_id"))
                            .transactionStatusId(r.getInt("transaction_status_id"))
                            .date(r.getString("date"))
                            .build());
        return purchaseTransactions;
    }
}
