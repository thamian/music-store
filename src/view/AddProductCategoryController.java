package view;

import database.table.row.ProductCategory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.Main;
import view.model.ProductCategoryView;

import java.sql.SQLException;

public class AddProductCategoryController {
    @FXML
    private TextField nameTextField;

    private Main main;
    private Stage stage;

    private ProductCategoryView productCategoryView;

    private OverviewController overviewController;

    private ObservableList<ProductCategory> productCategoryObservableList = FXCollections.observableArrayList();

    @FXML
    private void initialize() {

    }

    public void set(Main main, ProductCategoryView productCategoryView, OverviewController overviewController, Stage stage) {
        this.main = main;
        this.productCategoryView = productCategoryView;
        this.stage = stage;
        this.overviewController = overviewController;

        if (productCategoryView != null) {
            fillFields();
        }
    }

    @FXML
    private void handleAdd() {
        if (isInputValid()) {
            int id = 0;
            if (productCategoryView != null) {
                id = Integer.parseInt(productCategoryView.getId());
            }
            ProductCategory productCategory = new ProductCategory(id, nameTextField.getText());
            stage.close();
            if (productCategoryView != null) {
                try {
                    productCategory.updateIn(main.data().database(), "UPDATE product_categories SET name = ? WHERE id = ?");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    productCategory.insertInto(main.data().database(), "INSERT INTO product_categories (name) values(?)");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            overviewController.productCategoriesController().update();
        }
    }

    @FXML
    private void handleCancel() {
        stage.close();
    }

    private void fillFields() {
        nameTextField.setText(productCategoryView.getName());
    }

    private boolean isInputValid() {
        String errorMessage = "";

        if (nameTextField.getText() == null || nameTextField.getText().length() == 0) {
            errorMessage += "Podano niepoprawną nazwę kategorii\n";
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
