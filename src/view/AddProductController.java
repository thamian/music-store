package view;

import database.Database;
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

import java.sql.SQLException;
import java.util.ArrayList;

public class AddProductController {
    @FXML
    private TextField nameTextField;
    @FXML
    private ComboBox<ProductCategory> productCategoryComboBox;
    @FXML
    private TextField priceTextField;
    @FXML
    private TextArea descriptionTextArea;

    private Stage dialogStage;

    private Database database;

    private Product product;
    private boolean addClicked;

    ArrayList<ProductCategory> productCategories;

    public ObservableList<ProductCategory> productCategoryObservableList = FXCollections.observableArrayList();

    @FXML
    private void initialize() {

    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setDatabase(Database database) {
        this.database = database;
    }

    public void setProductCategories(ArrayList<ProductCategory> productCategories) {
        this.productCategories = productCategories;
        for (ProductCategory productCategory : productCategories) {
            productCategoryObservableList.add(productCategory);
        }
        productCategoryComboBox.setItems(productCategoryObservableList);
    }

    public boolean isAddClicked() {
        return addClicked;
    }

    @FXML
    private void handleAdd() {
        if (isInputValid()) {
            product = new Product.Builder(0)
                    .name(nameTextField.getText())
                    .productCategoryId(productCategoryComboBox.getValue().getId())
                    .description(descriptionTextArea.getText())
                    .price((int) Float.parseFloat(priceTextField.getText()) * 100)
                    .build();
            try {
                product.insertInto(database, "INSERT INTO products(name, product_category_id, description, price) values(?, ?, ?, ?)");

            } catch (SQLException e) {
                e.printStackTrace();
            }

            addClicked = true;
            dialogStage.close();
        }
    }

    @FXML
    private void handleCancel() {
        dialogStage.close();
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
            alert.initOwner(dialogStage);
            alert.setTitle("Wprowadzono nieprawidłowe dane");
            alert.setHeaderText("Wprowadzone dane są nieprawidłowe");
            alert.setContentText(errorMessage);
            alert.getDialogPane().getStylesheets().add(getClass().getResource("../view/style/bootstrap3.css").toExternalForm());
            alert.showAndWait();

            return false;
        }
    }
}
