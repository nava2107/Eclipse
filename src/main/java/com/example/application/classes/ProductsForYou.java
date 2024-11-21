package com.example.application.classes;

import java.util.ArrayList;
import java.util.List;

public class ProductsForYou {

    private List<Product> recommendedProducts;

    public ProductsForYou() {
        this.recommendedProducts = new ArrayList<>();
    }

    public void addProductRecommendation(Product product) {
        recommendedProducts.add(product);
        System.out.println("Added recommended product: " + product.getName());
    }

    public void removeProductRecommendation(int productId) {
        recommendedProducts.removeIf(product -> product.getId() == productId);
        System.out.println("Removed product with ID: " + productId + " from recommendations.");
    }

    public void listRecommendedProducts() {
        System.out.println("Recommended products for you:");
        for (Product product : recommendedProducts) {
            System.out.println(product);
        }
    }

    public List<Product> filterByCategory(String category) {
        List<Product> filteredProducts = new ArrayList<>();
        for (Product product : recommendedProducts) {
            if (product.getCategory().equalsIgnoreCase(category)) {
                filteredProducts.add(product);
            }
        }
        return filteredProducts;
    }

    public List<Product> filterByPriceRange(double minPrice, double maxPrice) {
        List<Product> filteredProducts = new ArrayList<>();
        for (Product product : recommendedProducts) {
            if (product.getPrice() >= minPrice && product.getPrice() <= maxPrice) {
                filteredProducts.add(product);
            }
        }
        return filteredProducts;
    }
}
