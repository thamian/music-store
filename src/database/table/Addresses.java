package database.table;

import database.Database;
import database.table.row.Address;
import database.table.row.TableRow;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class Addresses implements Table {
    @Override
    public ArrayList<Address> toList(Database database, ResultSet r) throws SQLException {
        ArrayList<Address> addresses = new ArrayList<>();
        while (r.next())
            addresses.add(
                    new Address.Builder(r.getInt("id"))
                            .street(r.getString("street"))
                            .homeNumber(r.getString("home_number"))
                            .flatNumber(r.getString("flat_number"))
                            .postCode(r.getString("post_code"))
                            .city(r.getString("city"))
                            .state(r.getString("state"))
                            .country(r.getString("country"))
                            .build());
        return addresses;
    }
}
