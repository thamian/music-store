package database.table;

import database.Database;
import database.table.row.Product;
import database.table.row.TableRow;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Products implements Table {
    @Override
    public ArrayList<TableRow> toList(Database database, ResultSet r) throws SQLException {
        ArrayList<TableRow> products = new ArrayList<>();
        while (r.next())
            products.add(
                    new Product.Builder(r.getInt("id"))
                            .name(r.getString("name"))
                            .productCategoryId(r.getInt("product_category_id"))
                            .description(r.getString("description"))
                            .price(r.getInt("price"))
                            .build());
        return products;
    }
}
