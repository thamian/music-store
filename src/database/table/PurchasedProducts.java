package database.table;

import database.Database;
import database.table.row.PurchasedProduct;
import database.table.row.TableRow;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PurchasedProducts implements Table {
    @Override
    public ArrayList<PurchasedProduct> toList(Database database, ResultSet r) throws SQLException {
        ArrayList<PurchasedProduct> purchasedProducts = new ArrayList<>();
        while (r.next())
            purchasedProducts.add(
                    new PurchasedProduct.Builder(r.getInt("id"))
                            .purchaseTransactionId(r.getInt("purchase_transaction_id"))
                            .stockProductId(r.getInt("stock_product_id"))
                            .payment(r.getInt("payment"))
                            .build());
        return purchasedProducts;
    }
}
