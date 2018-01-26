package database.table;

import database.Database;
import database.table.row.Client;
import database.table.row.TableRow;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Clients implements Table {
    @Override
    public ArrayList<Client> toList(Database database, ResultSet r) throws SQLException {
        ArrayList<Client> clients = new ArrayList<>();
        while (r.next())
            clients.add(
                    new Client.Builder(r.getInt("id"))
                            .name(r.getString("name"))
                            .phoneNumber(r.getString("phone_number"))
                            .addressId(r.getInt("address_id"))
                            .build());
        return clients;
    }
}
