package database.table.row;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Product implements TableRow {
    private final int id;
    private final String name;
    private final int productCategoryId;
    private final String description;
    private final int price;

    private Product(final Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.productCategoryId = builder.productCategoryId;
        this.description = builder.description;
        this.price = builder.price;
    }

    @Override
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getProductCategoryId() {
        return productCategoryId;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public static class Builder {
        private final int id;
        private String name;
        private int productCategoryId;
        private String description;
        private int price;

        public Builder(final int id) {
            this.id = id;
        }

        public Builder name(final String name) {
            this.name = name;
            return this;
        }

        public Builder productCategoryId(final int productCategoryId) {
            this.productCategoryId = productCategoryId;
            return this;
        }

        public Builder description(final String description) {
            this.description = description;
            return this;
        }

        public Builder price(final int price) {
            this.price = price;
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    }

    @Override
    public PreparedStatement prepareInsertStatement(Connection connection, String sql) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, name);
        preparedStatement.setInt(2, productCategoryId);
        preparedStatement.setString(3, description);
        preparedStatement.setInt(4, price);
        return preparedStatement;
    }

    @Override
    public PreparedStatement prepareUpdateStatement(Connection connection, String sql) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, name);
        preparedStatement.setInt(2, productCategoryId);
        preparedStatement.setString(3, description);
        preparedStatement.setInt(4, price);
        preparedStatement.setInt(5, id);
        return preparedStatement;
    }
}
