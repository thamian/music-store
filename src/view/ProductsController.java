package view;

import database.table.row.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import main.Main;
import view.model.ProductView;

import java.sql.SQLException;

public class ProductsController {
    @FXML
    private TableView<ProductView> productViewsTable;
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

    @FXML
    private Button editButton;
    @FXML
    private Button deleteButton;

    private ObservableList<ProductView> productViews = FXCollections.observableArrayList();

    private Main main;
    private OverviewController overviewController;

    public void set(Main main, OverviewController overviewController) {
        this.main = main;
        this.overviewController = overviewController;

        for (Product product : main.data().products())
            productViews.add(new ProductView(product, main.data().productCategories()));

        productViewsTable.setItems(productViews);

        productViewsTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                editButton.setDisable(false);
                deleteButton.setDisable(false);
            } else {
                editButton.setDisable(true);
                deleteButton.setDisable(true);
            }
        });
    }

    public void update() {
        main.data().selectProducts();
        productViews.clear();
        for (Product product : main.data().products())
            productViews.add(new ProductView(product, main.data().productCategories()));
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
        main.showAddProductDialog(null, "Dodawanie produktu");
    }

    @FXML
    private void handleEditProduct() {
        main.showAddProductDialog(productViewsTable.getSelectionModel().getSelectedItem(), "Edycja produktu");
    }

    @FXML
    private void handleDeleteProduct() {
        int selectedIndex = productViewsTable.getSelectionModel().getSelectedIndex();
        int id = Integer.parseInt(productViewsTable.getItems().get(selectedIndex).getId());
        productViews.remove(selectedIndex);

        for (Product product : main.data().products()) {
            if (product.getId() == id) {
                try {
                    product.deleteFrom(main.data().database(), "DELETE FROM products WHERE id = ?;");
                    main.data().products().remove(product);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
