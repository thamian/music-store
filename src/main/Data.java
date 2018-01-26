package main;

import database.Database;
import database.table.ProductCategories;
import database.table.Products;
import database.table.PurchaseTransactions;
import database.table.SaleTransactions;
import database.table.row.Product;
import database.table.row.ProductCategory;
import database.table.row.PurchaseTransaction;
import database.table.row.SaleTransaction;

import java.sql.SQLException;
import java.util.ArrayList;

public class Data {
    private Database database;
    private ArrayList<Product> products;
    private ArrayList<SaleTransaction> saleTransactions;
    private ArrayList<PurchaseTransaction> purchaseTransactions;
    private ArrayList<ProductCategory> productCategories;

    public Data() {
        try {
            database = new Database("jdbc:sqlite:music-store.db");
            products = (ArrayList<Product>) new Products().selectFrom(database, "SELECT * FROM products;");
            saleTransactions = (ArrayList<SaleTransaction>) new SaleTransactions().selectFrom(database, "SELECT * FROM sale_transactions;");
            purchaseTransactions = (ArrayList<PurchaseTransaction>) new PurchaseTransactions().selectFrom(database, "SELECT * FROM purchase_transactions;");
            productCategories = (ArrayList<ProductCategory>) new ProductCategories().selectFrom(database, "SELECT * FROM product_categories;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Database database() {
        return database;
    }

    public ArrayList<Product> products() {
        return products;
    }

    public ArrayList<SaleTransaction> saleTransactions() {
        return saleTransactions;
    }

    public ArrayList<PurchaseTransaction> purchaseTransactions() {
        return purchaseTransactions;
    }

    public ArrayList<ProductCategory> productCategories() {
        return productCategories;
    }

    public void selectProducts() {
        try {
            products = (ArrayList<Product>) new Products().selectFrom(database, "SELECT * FROM products;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void selectCategories() {
        try {
            productCategories = (ArrayList<ProductCategory>) new ProductCategories().selectFrom(database, "SELECT * FROM product_categories;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
