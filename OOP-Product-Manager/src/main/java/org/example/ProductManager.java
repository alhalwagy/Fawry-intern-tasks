package org.example;

import java.util.ArrayList;
import java.util.List;

public class ProductManager {

    private List<Product> products;

    public ProductManager() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product){
        products.add(product);
    }

    public void removeProduct(int productId){

        products.removeIf(product -> product.getId()==productId);

    }

    public void viewAllProducts(){

        for (Product product :products) {
            System.out.println(product);
        }

    }

    public void updateStock(int productId, int newStock){

        for(Product product:products){

            if(product.getId() == productId){

                product.setStockQuantity(newStock);

            }

        }

    }

    public List<Product> getProducts() {
        return products;
    }
}
