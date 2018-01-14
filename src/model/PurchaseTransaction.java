package model;

public class PurchaseTransaction {

    private final int id;
    private final Vendor vendor;
    private final TransactionStatus transactionStatus;
    private final String date;

    private PurchaseTransaction(final Builder builder) {
        this.id = builder.id;
        this.vendor = builder.vendor;
        this.transactionStatus = builder.transactionStatus;
        this.date = builder.date;
    }

    public int getId() {
        return id;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public TransactionStatus getTransactionStatus() {
        return transactionStatus;
    }

    public String getDate() {
        return date;
    }

    public static class Builder {
        private final int id;
        private Vendor vendor;
        private TransactionStatus transactionStatus;
        private String date;

        public Builder(final int id) {
            this.id = id;
        }

        public Builder vendor(final Vendor vendor) {
            this.vendor = vendor;
            return this;
        }

        public Builder transactionStatus(final TransactionStatus transactionStatus) {
            this.transactionStatus = transactionStatus;
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
}
