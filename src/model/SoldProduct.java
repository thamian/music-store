package model;

public class SoldProduct {

    private final int id;
    private final SaleTransaction saleTransaction;
    private final StockProduct stockProduct;
    private final int payment;

    private SoldProduct(final Builder builder) {
        this.id = builder.id;
        this.saleTransaction = builder.saleTransaction;
        this.stockProduct = builder.stockProduct;
        this.payment = builder.payment;
    }

    public int getId() {
        return id;
    }

    public SaleTransaction getSaleTransaction() {
        return saleTransaction;
    }

    public StockProduct getStockProduct() {
        return stockProduct;
    }

    public int getPayment() {
        return payment;
    }

    public static class Builder {
        private final int id;
        private SaleTransaction saleTransaction;
        private StockProduct stockProduct;
        private int payment;

        public Builder(final int id) {
            this.id = id;
        }

        public Builder saleTransaction(final SaleTransaction saleTransaction) {
            this.saleTransaction = saleTransaction;
            return this;
        }

        public Builder stockProduct(final StockProduct stockProduct) {
            this.stockProduct = stockProduct;
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
}
