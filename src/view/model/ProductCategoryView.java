package view.model;

import database.table.row.ProductCategory;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ProductCategoryView {
    private StringProperty id;
    private StringProperty name;

    public ProductCategoryView(ProductCategory productCategory) {
        id = new SimpleStringProperty(String.valueOf(productCategory.getId()));
        name = new SimpleStringProperty(productCategory.getName());
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
}
