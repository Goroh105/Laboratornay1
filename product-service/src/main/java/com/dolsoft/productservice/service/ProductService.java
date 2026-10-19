package com.dolsoft.productservice.service;

import com.dolsoft.productservice.model.Product;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ProductService {

    private final Map<Integer, Product> productStorage = new ConcurrentHashMap<>();

    public Product getProduct(String productId) {
        int id = Integer.parseInt(productId);
        Product product = productStorage.get(id);
        if (product == null) {
            // Демонстрационные данные, если товар не найден
            product = new Product();
            product.setId(id);
            product.setName("Software product");
            product.setSize("Standard");
            product.setWeight(1.5);
        }
        return product;
    }

    public String createProduct(Product product) {
        if (product == null) {
            return "Product is null";
        }
        product.setId(new Random().nextInt(10000));
        productStorage.put(product.getId(), product);
        return String.format("This is the post and the object is: %s", product);
    }

    public String updateProduct(Product product) {
        if (product == null) {
            return "Product is null";
        }
        productStorage.put(product.getId(), product);
        return String.format("This is the put and the object is: %s", product);
    }

    public String deleteProduct(String productId) {
        int id = Integer.parseInt(productId);
        productStorage.remove(id);
        return String.format("Deleting product with id %s", productId);
    }
}