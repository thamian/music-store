package model;

public class Product {

    private final int id;
    private final String name;
    private final ProductCategory productCategory;
    private final String description;
    private final int price;

    private Product(final Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.productCategory = builder.productCategory;
        this.description = builder.description;
        this.price = builder.price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public static class Builder {
        private final int id;
        private String name;
        private ProductCategory productCategory;
        private String description;
        private int price;

        public Builder(final int id) {
            this.id = id;
        }

        public Builder name(final String name) {
            this.name = name;
            return this;
        }

        public Builder productCategory(final ProductCategory productCategory) {
            this.productCategory = productCategory;
            return this;
        }

        public Builder description(final String description) {
            this.description = description;
            return this;
        }

        public Builder price(final int price) {
            this.price = price;
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    }
}
