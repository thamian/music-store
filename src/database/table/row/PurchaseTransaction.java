package database.table.row;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PurchaseTransaction implements TableRow {
    private final int id;
    private final int vendorId;
    private final int transactionStatusId;
    private final String date;

    private PurchaseTransaction(final Builder builder) {
        this.id = builder.id;
        this.vendorId = builder.vendorId;
        this.transactionStatusId = builder.transactionStatusId;
        this.date = builder.date;
    }

    @Override
    public int getId() {
        return id;
    }

    public int getVendorId() {
        return vendorId;
    }

    public int getTransactionStatusId() {
        return transactionStatusId;
    }

    public String getDate() {
        return date;
    }

    public static class Builder {
        private final int id;
        private int vendorId;
        private int transactionStatusId;
        private String date;

        public Builder(final int id) {
            this.id = id;
        }

        public Builder vendorId(final int vendorId) {
            this.vendorId = vendorId;
            return this;
        }

        public Builder transactionStatusId(final int transactionStatusId) {
            this.transactionStatusId = transactionStatusId;
            return this;
        }

        public Builder date(final String date) {
            this.date = date;
            return this;
        }

        public PurchaseTransaction build() {
            return new PurchaseTransaction(this);
        }
    }

    @Override
    public PreparedStatement prepareInsertStatement(Connection connection, String sql) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, vendorId);
        preparedStatement.setInt(2, transactionStatusId);
        preparedStatement.setString(3, date);
        return preparedStatement;
    }

    @Override
    public PreparedStatement prepareUpdateStatement(Connection connection, String sql) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, vendorId);
        preparedStatement.setInt(2, transactionStatusId);
        preparedStatement.setString(3, date);
        preparedStatement.setInt(4, id);
        return preparedStatement;
    }
}
