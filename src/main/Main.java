package main;

import database.table.row.Product;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import view.AddProductCategoryController;
import view.AddProductController;
import view.OverviewController;
import view.model.ProductCategoryView;
import view.model.ProductView;

public class Main extends Application {
    private Data data = new Data();
    private Stage mainStage;

    private OverviewController overviewController;

    public Data data() {
        return data;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/overview.fxml"));
        Scene scene = new Scene(loader.load());
        primaryStage.setTitle("Sklep muzyczny \"Guitar Hero\", build 4815162342");
        primaryStage.setScene(scene);
        primaryStage.show();

        mainStage = primaryStage;

        overviewController = loader.getController();
        overviewController.set(this);
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        data.database().closeConnection();
    }

    public void showAddProductDialog(ProductView product, String windowTitle) {
        try {
            FXMLLoader loader = new FXMLLoader((getClass().getResource("../view/add_product.fxml")));

            Stage stage = new Stage();
            stage.setTitle(windowTitle);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(mainStage);
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);

            AddProductController addProductController = loader.getController();
            addProductController.set(this, product, overviewController, stage);

            stage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showAddCategoryDialog(ProductCategoryView productCategoryView, String windowTitle) {
        try {
            FXMLLoader loader = new FXMLLoader((getClass().getResource("../view/add_product_category.fxml")));

            Stage stage = new Stage();
            stage.setTitle(windowTitle);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(mainStage);
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);

            AddProductCategoryController addProductCategoryController = loader.getController();
            addProductCategoryController.set(this, productCategoryView, overviewController, stage);

            stage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
