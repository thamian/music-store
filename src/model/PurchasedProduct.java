package model;

public class PurchasedProduct {

    private final int id;
    private final PurchaseTransaction purchaseTransaction;
    private final StockProduct stockProduct;
    private final int payment;

    private PurchasedProduct(final Builder builder) {
        this.id = builder.id;
        this.purchaseTransaction = builder.purchaseTransaction;
        this.stockProduct = builder.stockProduct;
        this.payment = builder.payment;
    }

    public int getId() {
        return id;
    }

    public PurchaseTransaction getPurchaseTransaction() {
        return purchaseTransaction;
    }

    public StockProduct getStockProduct() {
        return stockProduct;
    }

    public int getPayment() {
        return payment;
    }

    public static class Builder {
        private final int id;
        private PurchaseTransaction purchaseTransaction;
        private StockProduct stockProduct;
        private int payment;

        public Builder(final int id) {
            this.id = id;
        }

        public Builder purchaseTransaction(final PurchaseTransaction purchaseTransaction) {
            this.purchaseTransaction = purchaseTransaction;
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

        public PurchasedProduct build() {
            return new PurchasedProduct(this);
        }
    }
}
