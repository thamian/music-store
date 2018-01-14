package model;

public class Vendor {

    private final int id;
    private final String name;
    private final String phoneNumber;
    private final String email;
    private final String nip;
    private final String regon;
    private final Address address;

    private Vendor(final Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.phoneNumber = builder.phoneNumber;
        this.email = builder.email;
        this.nip = builder.nip;
        this.regon = builder.regon;
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

    public String getEmail() {
        return email;
    }

    public String getNip() {
        return nip;
    }

    public String getRegon() {
        return regon;
    }

    public Address getAddress() {
        return address;
    }

    public static class Builder {
        private final int id;
        private String name;
        private String phoneNumber;
        private String email;
        private String nip;
        private String regon;
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

        public Builder email(final String email) {
            this.email = email;
            return this;
        }

        public Builder nip(final String nip) {
            this.nip = nip;
            return this;
        }

        public Builder regon(final String regon) {
            this.regon = regon;
            return this;
        }

        public Builder address(final Address address) {
            this.address = address;
            return this;
        }

        public Vendor build() {
            return new Vendor(this);
        }
    }
}
