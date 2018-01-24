package database.table.row;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Client implements TableRow {
    private final int id;
    private final String name;
    private final String phoneNumber;
    private final int addressId;

    private Client(final Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.phoneNumber = builder.phoneNumber;
        this.addressId = builder.addressId;
    }

    @Override
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getAddressId() {
        return addressId;
    }

    public static class Builder {
        private final int id;
        private String name;
        private String phoneNumber;
        private int addressId;

        public Builder(final int id) {
            this.id = id;
        }

        public Builder name(final String name) {
            this.name = name;
            return this;
        }

        public Builder phoneNumber(final String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder addressId(final int addressId) {
            this.addressId = addressId;
            return this;
        }

        public Client build() {
            return new Client(this);
        }
    }

    @Override
    public PreparedStatement prepareInsertStatement(Connection connection, String sql) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, phoneNumber);
        preparedStatement.setInt(3, addressId);
        return preparedStatement;
    }

    @Override
    public PreparedStatement prepareUpdateStatement(Connection connection, String sql) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, phoneNumber);
        preparedStatement.setInt(3, addressId);
        preparedStatement.setInt(4, id);
        return preparedStatement;
    }
}
