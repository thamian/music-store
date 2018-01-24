package database.table.row;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StockProduct implements TableRow {
    private final int id;
    private final int productId;
    private final int promotionalPrice;
    private final int itemConditionId;
    private final int storagePlaceId;
    private final String serialNumber;

    private StockProduct(final Builder builder) {
        this.id = builder.id;
        this.productId = builder.productId;
        this.promotionalPrice = builder.promotionalPrice;
        this.itemConditionId = builder.itemConditionId;
        this.storagePlaceId = builder.storagePlaceId;
        this.serialNumber = builder.serialNumber;
    }

    @Override
    public int getId() {
        return id;
    }

    public int getProductId() {
        return productId;
    }

    public int getPromotionalPrice() {
        return promotionalPrice;
    }

    public int getItemConditionId() {
        return itemConditionId;
    }

    public int getStoragePlaceId() {
        return storagePlaceId;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public static class Builder {
        private final int id;
        private int productId;
        private int promotionalPrice;
        private int itemConditionId;
        private int storagePlaceId;
        private String serialNumber;

        public Builder(final int id) {
            this.id = id;
        }

        public Builder productId(final int productId) {
            this.productId = productId;
            return this;
        }

        public Builder promotionalPrice(final int promotionalPrice) {
            this.promotionalPrice = promotionalPrice;
            return this;
        }

        public Builder itemConditionId(final int itemConditionId) {
            this.itemConditionId = itemConditionId;
            return this;
        }

        public Builder storagePlaceId(final int storagePlaceId) {
            this.storagePlaceId = storagePlaceId;
            return this;
        }

        public Builder serialNumber(final String serialNumber) {
            this.serialNumber = serialNumber;
            return this;
        }

        public StockProduct build() {
            return new StockProduct(this);
        }
    }

    @Override
    public PreparedStatement prepareInsertStatement(Connection connection, String sql) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, productId);
        preparedStatement.setInt(2, promotionalPrice);
        preparedStatement.setInt(3, itemConditionId);
        preparedStatement.setInt(4, storagePlaceId);
        preparedStatement.setString(5, serialNumber);
        return preparedStatement;
    }

    @Override
    public PreparedStatement prepareUpdateStatement(Connection connection, String sql) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, productId);
        preparedStatement.setInt(2, promotionalPrice);
        preparedStatement.setInt(3, itemConditionId);
        preparedStatement.setInt(4, storagePlaceId);
        preparedStatement.setString(5, serialNumber);
        preparedStatement.setInt(6, id);
        return preparedStatement;
    }
}
