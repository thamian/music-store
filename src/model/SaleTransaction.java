package model;

public class SaleTransaction {

    private final int id;
    private final Client client;
    private final TransactionStatus transactionStatus;
    private final String date;

    private SaleTransaction(final Builder builder) {
        this.id = builder.id;
        this.client = builder.client;
        this.transactionStatus = builder.transactionStatus;
        this.date = builder.date;
    }

    public int getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public TransactionStatus getTransactionStatus() {
        return transactionStatus;
    }

    public String getDate() {
        return date;
    }

    public static class Builder {
        private final int id;
        private Client client;
        private TransactionStatus transactionStatus;
        private String date;

        public Builder(final int id) {
            this.id = id;
        }

        public Builder client(final Client client) {
            this.client = client;
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

        public SaleTransaction build() {
            return new SaleTransaction(this);
        }
    }
}
