package model;

public class StockProduct {

    private final int id;
    private final Product product;
    private final int promotionalPrice;
    private final ItemCondition itemCondition;
    private final StoragePlace storagePlace;
    private final String serialNumber;

    private StockProduct(final Builder builder) {
        this.id = builder.id;
        this.product = builder.product;
        this.promotionalPrice = builder.promotionalPrice;
        this.itemCondition = builder.itemCondition;
        this.storagePlace = builder.storagePlace;
        this.serialNumber = builder.serialNumber;
    }

    public int getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public int getPromotionalPrice() {
        return promotionalPrice;
    }

    public ItemCondition getItemCondition() {
        return itemCondition;
    }

    public StoragePlace getStoragePlace() {
        return storagePlace;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public static class Builder {
        private final int id;
        private Product product;
        private int promotionalPrice;
        private ItemCondition itemCondition;
        private StoragePlace storagePlace;
        private String serialNumber;

        public Builder(final int id) {
            this.id = id;
        }

        public Builder product(final Product product) {
            this.product = product;
            return this;
        }

        public Builder promotionalPrice(final int promotionalPrice) {
            this.promotionalPrice = promotionalPrice;
            return this;
        }

        public Builder itemCondition(final ItemCondition itemCondition) {
            this.itemCondition = itemCondition;
            return this;
        }

        public Builder storagePlace(final StoragePlace storagePlace) {
            this.storagePlace = storagePlace;
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
}
