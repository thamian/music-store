package view;

import database.table.row.ProductCategory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import main.Main;
import view.model.ProductCategoryView;

import java.sql.SQLException;

public class ProductCategoriesController {
    @FXML
    private TableView<ProductCategoryView> productCategoryViewsTable;
    @FXML
    private TableColumn<ProductCategoryView, String> idColumn;
    @FXML
    private TableColumn<ProductCategoryView, String> nameColumn;

    @FXML
    private Button editButton;
    @FXML
    private Button deleteButton;

    private ObservableList<ProductCategoryView> productCategoryViews = FXCollections.observableArrayList();

    private Main main;
    private OverviewController overviewController;

    public void set(Main main, OverviewController overviewController) {
        this.main = main;
        this.overviewController = overviewController;

        for (ProductCategory productCategory : main.data().productCategories())
            productCategoryViews.add(new ProductCategoryView(productCategory));

        productCategoryViewsTable.setItems(productCategoryViews);

        productCategoryViewsTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                editButton.setDisable(false);
                deleteButton.setDisable(false);
            } else {
                editButton.setDisable(true);
                deleteButton.setDisable(true);
            }
        });
    }

    @FXML
    private void initialize() {
        idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty());
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
    }

    @FXML
    private void handleNewCategory() {
        main.showAddCategoryDialog(null, "Dodawanie kategorii produktu");
    }

    @FXML
    private void handleEditCategory() {
        main.showAddCategoryDialog(productCategoryViewsTable.getSelectionModel().getSelectedItem(), "Edycja kategorii produktu");
    }

    public void update() {
        main.data().selectCategories();
        productCategoryViews.clear();
        for (ProductCategory productCategory : main.data().productCategories())
            productCategoryViews.add(new ProductCategoryView(productCategory));
    }

    @FXML
    private void handleDeleteCategory() {
        int selectedIndex = productCategoryViewsTable.getSelectionModel().getSelectedIndex();
        int id = Integer.parseInt(productCategoryViewsTable.getItems().get(selectedIndex).getId());

        for (ProductCategory productCategory : main.data().productCategories()) {
            if (productCategory.getId() == id) {
                try {
                    productCategory.deleteFrom(main.data().database(), "DELETE FROM product_categories WHERE id = ?;");
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("nie da sie");
                }
                update();
                return;
            }
        }
    }
}
