package view;

import database.table.row.Product;
import database.table.row.ProductCategory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.Main;
import view.model.ProductView;

import java.sql.SQLException;

public class AddProductController {
    @FXML
    private TextField nameTextField;
    @FXML
    private ComboBox<ProductCategory> productCategoryComboBox;
    @FXML
    private TextField priceTextField;
    @FXML
    private TextArea descriptionTextArea;

    private Main main;
    private Stage stage;

    private ProductView productView;

    private OverviewController overviewController;

    private ObservableList<ProductCategory> productCategoryObservableList = FXCollections.observableArrayList();

    @FXML
    private void initialize() {

    }

    public void set(Main main, ProductView product, OverviewController overviewController, Stage stage) {
        this.main = main;
        this.productView = product;
        this.stage = stage;
        this.overviewController = overviewController;

        if (product != null) {
            fillFields();
        }

        for (ProductCategory productCategory : main.data().productCategories()) {
            productCategoryObservableList.add(productCategory);
        }
        productCategoryComboBox.setItems(productCategoryObservableList);
    }

    @FXML
    private void handleAdd() {
        if (isInputValid()) {
            int id = 0;
            if (productView != null) {
                id = Integer.parseInt(productView.getId());
            }
            Product product = new Product.Builder(id)
                    .name(nameTextField.getText())
                    .productCategoryId(productCategoryComboBox.getValue().getId())
                    .description(descriptionTextArea.getText())
                    .price((int) Float.parseFloat(priceTextField.getText()) * 100)
                    .build();
            stage.close();
            if (productView != null) {
                try {
                    product.updateIn(main.data().database(), "UPDATE products SET name = ?, product_category_id = ?, description = ?, price = ? WHERE id = ?");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    product.insertInto(main.data().database(), "INSERT INTO products(name, product_category_id, description, price) values(?, ?, ?, ?)");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            overviewController.productsController().update();
        }
    }

    @FXML
    private void handleCancel() {
        stage.close();
    }

    private void fillFields() {
        for (Product findProduct : main.data().products()) {
            if (Integer.parseInt(productView.getId()) == findProduct.getId()) {
                descriptionTextArea.setText(findProduct.getDescription());
                break;
            }
        }
        nameTextField.setText(productView.getName());
        priceTextField.setText(productView.getPrice());
    }

    private boolean isInputValid() {
        String errorMessage = "";

        if (nameTextField.getText() == null || nameTextField.getText().length() == 0) {
            errorMessage += "Podano niepoprawną nazwę produktu\n";
        }
        boolean validPrice = true;
        try {
            Float.parseFloat(priceTextField.getText());
        } catch(Exception e) {
            validPrice = false;
        }
        if (productCategoryComboBox.getValue() == null ) {
            errorMessage += "Nie wybrano kategorii\n";
        }
        if (priceTextField.getText() == null || priceTextField.getText().length() == 0 || !validPrice) {
            errorMessage += "Podano nieprawidłową cenę\n";
        }
        if (errorMessage.length() == 0) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(stage);
            alert.setTitle("Wprowadzono nieprawidłowe dane");
            alert.setHeaderText("Wprowadzone dane są nieprawidłowe");
            alert.setContentText(errorMessage);
            alert.getDialogPane().getStylesheets().add(getClass().getResource("../view/style/bootstrap3.css").toExternalForm());
            alert.showAndWait();

            return false;
        }
    }
}
