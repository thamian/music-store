package database.table;

import database.Database;
import database.table.row.SoldProduct;
import database.table.row.TableRow;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SoldProducts implements Table {
    @Override
    public ArrayList<TableRow> toList(Database database, ResultSet r) throws SQLException {
        ArrayList<TableRow> soldProducts = new ArrayList<>();
        while (r.next())
            soldProducts.add(
                    new SoldProduct.Builder(r.getInt("id"))
                            .saleTransactionId(r.getInt("sale_transaction_id"))
                            .stockProductId(r.getInt("stock_product_id"))
                            .payment(r.getInt("payment"))
                            .build());
        return soldProducts;
    }
}
