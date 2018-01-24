package main;

import database.Database;
import database.table.ProductCategories;
import database.table.Products;
import database.table.row.Product;
import database.table.row.ProductCategory;
import database.table.row.TableRow;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import view.AddProductController;
import view.MainController;
import view.model.ProductView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main extends Application {
    private Stage primaryStage;
    private AnchorPane layout;

    private Database database;

    public ObservableList<ProductView> productViewObservableList = FXCollections.observableArrayList();
    ArrayList<Product> products = new ArrayList<>();
    ArrayList<ProductCategory> productCategories = new ArrayList<>();

    public Main() {
        try {
            database = new Database("jdbc:sqlite:music-store.db");
            ArrayList<TableRow> productsGet = new Products().selectFrom(database, "SELECT * FROM products;");
            ArrayList<TableRow> categoriesGet = new ProductCategories().selectFrom(database, "SELECT * FROM product_categories;");

            for (TableRow tableRow : categoriesGet) {
                ProductCategory productCategory = (ProductCategory) tableRow;
                productCategories.add(productCategory);
            }

            for (TableRow tableRow : productsGet) {
                Product product = (Product) tableRow;
                products.add(product);
                productViewObservableList.add(new ProductView(product, productCategories));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Stacjonarny sklep muzyczny");
        initLayout();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        database.closeConnection();
    }

    private void initLayout() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../view/main.fxml"));
        layout = loader.load();

        Scene scene = new Scene(layout);
        scene.getStylesheets().add(getClass().getResource("../view/style/bootstrap3.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.show();

        MainController controller = loader.getController();
        controller.setMain(this);
    }

    public boolean showAddProductDialog() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../view/add_product.fxml"));
            AnchorPane page = loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Dodawanie produktu");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            scene.getStylesheets().add(getClass().getResource("../view/style/bootstrap3.css").toExternalForm());
            dialogStage.setScene(scene);

            AddProductController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setDatabase(database);
            controller.setProductCategories(productCategories);

            dialogStage.showAndWait();

            try {
                ArrayList<TableRow> productsGet = new Products().selectFrom(database, "SELECT * FROM products;");
                products = new ArrayList<>();
                productViewObservableList.clear();
                for (TableRow tableRow : productsGet) {
                    Product product = (Product) tableRow;
                    products.add(product);
                    productViewObservableList.add(new ProductView(product, productCategories));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return controller.isAddClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Database getDatabase() {
        return database;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
