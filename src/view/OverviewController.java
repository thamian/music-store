package view;

import javafx.fxml.FXML;
import main.Main;

public class OverviewController {
    @FXML
    private ProductsController productsController;
    @FXML
    private SaleTransactionsController saleTransactionsController;
    @FXML
    private PurchaseTransactionsController purchaseTransactionsController;
    @FXML
    private ProductCategoriesController productCategoriesController;

    private Main main;

    @FXML
    private void initialize() {

    }

    public void set(Main main) {
        this.main = main;
        productsController.set(main, this);
//        saleTransactionsController.set(main);
//        purchaseTransactionsController.set(main);
        productCategoriesController.set(main, this);
    }

    public ProductsController productsController() {
        return productsController;
    }

    public SaleTransactionsController saleTransactionsController() {
        return saleTransactionsController;
    }

    public PurchaseTransactionsController purchaseTransactionsController() {
        return purchaseTransactionsController;
    }

    public ProductCategoriesController productCategoriesController() {
        return productCategoriesController;
    }
}
