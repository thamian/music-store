package view;

import database.Database;
import database.table.row.Product;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import main.Main;
import view.model.ProductView;

public class MainController {
    @FXML
    private TableView<ProductView> productsViewTable;
    @FXML
    private TableColumn<ProductView, String> idColumn;
    @FXML
    private TableColumn<ProductView, String> nameColumn;
    @FXML
    private TableColumn<ProductView, String> productCategoryNameColumn;
    @FXML
    private TableColumn<ProductView, String> inventoryBalanceColumn;
    @FXML
    private TableColumn<ProductView, String> priceColumn;

    Database database;

    private Main main;

    public void setMain(Main main) {
        this.main = main;
        productsViewTable.setItems(main.productViewObservableList);
    }

    @FXML
    private void initialize() {
        idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty());
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        productCategoryNameColumn.setCellValueFactory(cellData -> cellData.getValue().productCategoryNameProperty());
        inventoryBalanceColumn.setCellValueFactory(cellData -> cellData.getValue().inventoryBalanceProperty());
        priceColumn.setCellValueFactory(cellData -> cellData.getValue().priceProperty());
    }

    @FXML
    private void handleNewProduct() {
        Product temporaryProduct;
        boolean addClicked = main.showAddProductDialog();
        if (addClicked) {

        }
    }

//    @FXML
//    private void handleEditPerson() {
//        Person selectedPerson = personTable.getSelectionModel().getSelectedItem();
//        if (selectedPerson != null) {
//            boolean okClicked = mainApp.showPersonEditDialog(selectedPerson);
//            if (okClicked) {
//                showPersonDetails(selectedPerson);
//            }
//
//        } else {
//            // Nothing selected.
//            Alert alert = new Alert(AlertType.WARNING);
//            alert.initOwner(mainApp.getPrimaryStage());
//            alert.setTitle("No Selection");
//            alert.setHeaderText("No Person Selected");
//            alert.setContentText("Please select a person in the table.");
//
//            alert.showAndWait();
//        }
//    }
}
