package view.model;

import database.table.row.Product;
import database.table.row.ProductCategory;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;

public class ProductView {
    private StringProperty id;
    private StringProperty name;
    private StringProperty productCategoryName;
    private StringProperty inventoryBalance;
    private StringProperty price;

    public ProductView(Product product, ArrayList<ProductCategory> productCategories) {
        id = new SimpleStringProperty(String.valueOf(product.getId()));
        name = new SimpleStringProperty(product.getName());

        for (ProductCategory productCategory : productCategories)
            if (productCategory.getId() == product.getProductCategoryId())
                productCategoryName = new SimpleStringProperty(productCategory.getName());

        inventoryBalance = new SimpleStringProperty(String.valueOf(0));

        float calculatedPrice = product.getPrice() / 100;
        price = new SimpleStringProperty(String.valueOf(calculatedPrice));
    }

    public String getId() {
        return id.get();
    }

    public StringProperty idProperty() {
        return id;
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public String getProductCategoryName() {
        return productCategoryName.get();
    }

    public StringProperty productCategoryNameProperty() {
        return productCategoryName;
    }

    public String getInventoryBalance() {
        return inventoryBalance.get();
    }

    public StringProperty inventoryBalanceProperty() {
        return inventoryBalance;
    }

    public String getPrice() {
        return price.get();
    }

    public StringProperty priceProperty() {
        return price;
    }
}
