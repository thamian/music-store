package database.table.row;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Vendor implements TableRow {
    private final int id;
    private final String name;
    private final String phoneNumber;
    private final String email;
    private final String nip;
    private final String regon;
    private final int addressId;

    private Vendor(final Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.phoneNumber = builder.phoneNumber;
        this.email = builder.email;
        this.nip = builder.nip;
        this.regon = builder.regon;
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

    public String getEmail() {
        return email;
    }

    public String getNip() {
        return nip;
    }

    public String getRegon() {
        return regon;
    }

    public int getAddressId() {
        return addressId;
    }

    public static class Builder {
        private final int id;
        private String name;
        private String phoneNumber;
        private String email;
        private String nip;
        private String regon;
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

        public Builder email(final String email) {
            this.email = email;
            return this;
        }

        public Builder nip(final String nip) {
            this.nip = nip;
            return this;
        }

        public Builder regon(final String regon) {
            this.regon = regon;
            return this;
        }

        public Builder addressId(final int addressId) {
            this.addressId = addressId;
            return this;
        }

        public Vendor build() {
            return new Vendor(this);
        }
    }

    @Override
    public PreparedStatement prepareInsertStatement(Connection connection, String sql) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, phoneNumber);
        preparedStatement.setString(3, email);
        preparedStatement.setString(4, nip);
        preparedStatement.setString(5, regon);
        preparedStatement.setInt(6, addressId);
        return preparedStatement;
    }

    @Override
    public PreparedStatement prepareUpdateStatement(Connection connection, String sql) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, phoneNumber);
        preparedStatement.setString(3, email);
        preparedStatement.setString(4, nip);
        preparedStatement.setString(5, regon);
        preparedStatement.setInt(6, addressId);
        preparedStatement.setInt(7, id);
        return preparedStatement;
    }
}
