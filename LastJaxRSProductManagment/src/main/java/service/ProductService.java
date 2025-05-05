package service;

import Model.Product;

import java.util.HashMap;
import java.util.Map;

public class ProductService {
    // Make products map static so it maintains state across requests
    private static Map<Integer, Product> products = new HashMap<>();
    private static int currentId = 1;

    // Find all products
    public Map<Integer, Product> findAll() {
        return products;
    }

    // Find product by ID
    public Product findById(int id) {
        return products.get(id);
    }

    // Add a new product
    public void save(Product product) {
        product.setId(currentId++);
        products.put(product.getId(), product);
    }

    // Update a product
    public void update(Product product) {
        products.put(product.getId(), product);
    }

    // Delete a product
    public void delete(int id) {
        products.remove(id);
    }
}