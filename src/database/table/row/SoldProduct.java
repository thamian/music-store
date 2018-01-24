package database.table.row;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SoldProduct implements TableRow {
    private final int id;
    private final int saleTransactionId;
    private final int stockProductId;
    private final int payment;

    private SoldProduct(final Builder builder) {
        this.id = builder.id;
        this.saleTransactionId = builder.saleTransactionId;
        this.stockProductId = builder.stockProductId;
        this.payment = builder.payment;
    }

    @Override
    public int getId() {
        return id;
    }

    public int getSaleTransactionId() {
        return saleTransactionId;
    }

    public int getStockProductId() {
        return stockProductId;
    }

    public int getPayment() {
        return payment;
    }

    public static class Builder {
        private final int id;
        private int saleTransactionId;
        private int stockProductId;
        private int payment;

        public Builder(final int id) {
            this.id = id;
        }

        public Builder saleTransactionId(final int saleTransactionId) {
            this.saleTransactionId = saleTransactionId;
            return this;
        }

        public Builder stockProductId(final int stockProductId) {
            this.stockProductId = stockProductId;
            return this;
        }

        public Builder payment(final int payment) {
            this.payment = payment;
            return this;
        }

        public SoldProduct build() {
            return new SoldProduct(this);
        }
    }

    @Override
    public PreparedStatement prepareInsertStatement(Connection connection, String sql) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, saleTransactionId);
        preparedStatement.setInt(2, stockProductId);
        preparedStatement.setInt(3, payment);
        return preparedStatement;
    }

    @Override
    public PreparedStatement prepareUpdateStatement(Connection connection, String sql) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, saleTransactionId);
        preparedStatement.setInt(2, stockProductId);
        preparedStatement.setInt(3, payment);
        preparedStatement.setInt(4, id);
        return preparedStatement;
    }
}
