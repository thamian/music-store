package database.table;

import database.Database;
import database.table.row.ProductCategory;
import database.table.row.TableRow;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductCategories implements Table {
    @Override
    public ArrayList<TableRow> toList(Database database, ResultSet r) throws SQLException {
        ArrayList<TableRow> productCategories = new ArrayList<>();
        while (r.next())
            productCategories.add(
                    new ProductCategory(r.getInt("id"), r.getString("name"))
            );
        return productCategories;
    }
}
