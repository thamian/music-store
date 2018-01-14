package model;

public class Client {

    private final int id;
    private final String name;
    private final String phoneNumber;
    private final Address address;

    private Client(final Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.phoneNumber = builder.phoneNumber;
        this.address = builder.address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public static class Builder {
        private final int id;
        private String name;
        private String phoneNumber;
        private Address address;

        public Builder(final int id) {
            this.id = id;
        }

        public Builder name(final String name) {
            this.name = name;
            return this;
        }

        public Builder phoneNumber(final String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder address(final Address address) {
            this.address = address;
            return this;
        }

        public Client build() {
            return new Client(this);
        }
    }
}
