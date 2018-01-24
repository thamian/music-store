package database.table.row;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Address implements TableRow {
    private final int id;
    private final String street;
    private final String homeNumber;
    private final String flatNumber;
    private final String postCode;
    private final String city;
    private final String state;
    private final String country;

    private Address(final Builder builder) {
        this.id = builder.id;
        this.street = builder.street;
        this.homeNumber = builder.homeNumber;
        this.flatNumber = builder.flatNumber;
        this.postCode = builder.postCode;
        this.city = builder.city;
        this.state = builder.state;
        this.country = builder.country;
    }

    @Override
    public final int getId() {
        return id;
    }

    public final String getStreet() {
        return street;
    }

    public final String getHomeNumber() {
        return homeNumber;
    }

    public final String getFlatNumber() {
        return flatNumber;
    }

    public final String getPostCode() {
        return postCode;
    }

    public final String getCity() {
        return city;
    }

    public final String getState() {
        return state;
    }

    public final String getCountry() {
        return country;
    }

    public static class Builder {
        private final int id;
        private String street;
        private String homeNumber;
        private String flatNumber;
        private String postCode;
        private String city;
        private String state;
        private String country;

        public Builder(final int id) {
            this.id = id;
        }

        public final Builder street(final String street) {
            this.street = street;
            return this;
        }

        public final Builder homeNumber(final String homeNumber) {
            this.homeNumber = homeNumber;
            return this;
        }

        public final Builder flatNumber(final String flatNumber) {
            this.flatNumber = flatNumber;
            return this;
        }

        public final Builder postCode(final String postCode) {
            this.postCode = postCode;
            return this;
        }

        public final Builder city(final String city) {
            this.city = city;
            return this;
        }

        public final Builder state(final String state) {
            this.state = state;
            return this;
        }

        public final Builder country(final String country) {
            this.country = country;
            return this;
        }

        public final Address build() {
            return new Address(this);
        }
    }

    @Override
    public PreparedStatement prepareInsertStatement(Connection connection, String sql) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, street);
        preparedStatement.setString(2, homeNumber);
        preparedStatement.setString(3, flatNumber);
        preparedStatement.setString(4, postCode);
        preparedStatement.setString(5, city);
        preparedStatement.setString(6, state);
        preparedStatement.setString(7, country);
        return preparedStatement;
    }

    @Override
    public PreparedStatement prepareUpdateStatement(Connection connection, String sql) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, street);
        preparedStatement.setString(2, homeNumber);
        preparedStatement.setString(3, flatNumber);
        preparedStatement.setString(4, postCode);
        preparedStatement.setString(5, city);
        preparedStatement.setString(6, state);
        preparedStatement.setString(7, country);
        preparedStatement.setInt(8, id);
        return preparedStatement;
    }
}
