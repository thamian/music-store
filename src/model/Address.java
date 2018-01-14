package model;

public class Address {

    private final int id;
    private final String street;
    private final String homeNumber;
    private final String flatNumber;
    private final String postCode;
    private final String city;
    private final String state;
    private final String country;

    private Address(final Builder builder) {
        this.id = builder.id;
        this.street = builder.street;
        this.homeNumber = builder.homeNumber;
        this.flatNumber = builder.flatNumber;
        this.postCode = builder.postCode;
        this.city = builder.city;
        this.state = builder.state;
        this.country = builder.country;
    }

    public int getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public String getFlatNumber() {
        return flatNumber;
    }

    public String getPostCode() {
        return postCode;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public static class Builder {
        private final int id;
        private String street;
        private String homeNumber;
        private String flatNumber;
        private String postCode;
        private String city;
        private String state;
        private String country;

        public Builder(final int id) {
            this.id = id;
        }

        public Builder street(final String street) {
            this.street = street;
            return this;
        }

        public Builder homeNumber(final String homeNumber) {
            this.homeNumber = homeNumber;
            return this;
        }

        public Builder flatNumber(final String flatNumber) {
            this.flatNumber = flatNumber;
            return this;
        }

        public Builder postCode(final String postCode) {
            this.postCode = postCode;
            return this;
        }

        public Builder city(final String city) {
            this.city = city;
            return this;
        }

        public Builder state(final String state) {
            this.state = state;
            return this;
        }

        public Builder country(final String country) {
            this.country = country;
            return this;
        }

        public Address build() {
            return new Address(this);
        }
    }
}
