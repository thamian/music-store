package database.table;

import database.Database;
import database.table.row.TableRow;
import database.table.row.Vendor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Vendors implements Table {
    @Override
    public ArrayList<Vendor> toList(Database database, ResultSet r) throws SQLException {
        ArrayList<Vendor> vendors = new ArrayList<>();
        while (r.next())
            vendors.add(new Vendor.Builder(r.getInt("id"))
                    .name(r.getString("name"))
                    .phoneNumber(r.getString("phone_number"))
                    .email(r.getString("email"))
                    .nip(r.getString("nip"))
                    .regon(r.getString("regon"))
                    .addressId(r.getInt("address_id"))
                    .build()
            );
        return vendors;
    }
}
