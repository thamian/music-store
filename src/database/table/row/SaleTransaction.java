package database.table.row;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SaleTransaction implements TableRow {
    private final int id;
    private final int clientId;
    private final int transactionStatusId;
    private final String date;

    private SaleTransaction(final Builder builder) {
        this.id = builder.id;
        this.clientId = builder.clientId;
        this.transactionStatusId = builder.transactionStatusId;
        this.date = builder.date;
    }

    @Override
    public int getId() {
        return id;
    }

    public int getClientId() {
        return clientId;
    }

    public int getTransactionStatusId() {
        return transactionStatusId;
    }

    public String getDate() {
        return date;
    }

    public static class Builder {
        private final int id;
        private int clientId;
        private int transactionStatusId;
        private String date;

        public Builder(final int id) {
            this.id = id;
        }

        public Builder clientId(final int clientId) {
            this.clientId = clientId;
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

        public SaleTransaction build() {
            return new SaleTransaction(this);
        }
    }

    @Override
    public PreparedStatement prepareInsertStatement(Connection connection, String sql) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, clientId);
        preparedStatement.setInt(2, transactionStatusId);
        preparedStatement.setString(3, date);
        return preparedStatement;
    }

    @Override
    public PreparedStatement prepareUpdateStatement(Connection connection, String sql) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, clientId);
        preparedStatement.setInt(2, transactionStatusId);
        preparedStatement.setString(3, date);
        preparedStatement.setInt(4, id);
        return preparedStatement;
    }
}
