package database.table;

import database.Database;
import database.table.row.StockProduct;
import database.table.row.TableRow;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StockProducts implements Table {
    @Override
    public ArrayList<StockProduct> toList(Database database, ResultSet r) throws SQLException {
        ArrayList<StockProduct> stockProducts = new ArrayList<>();
        while (r.next())
            stockProducts.add(
                    new StockProduct.Builder(r.getInt("id"))
                            .productId(r.getInt("product_id"))
                            .promotionalPrice(r.getInt("promotional_price"))
                            .itemConditionId(r.getInt("item_condition_id"))
                            .storagePlaceId(r.getInt("storage_place_id"))
                            .serialNumber(r.getString("serial_number"))
                            .build());
        return stockProducts;
    }
}
