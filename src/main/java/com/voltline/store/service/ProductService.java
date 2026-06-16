package com.voltline.store.service;

import com.voltline.store.domain.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final List<Product> products = new ArrayList<>(List.of(
            new Product(1L, "Gaming Laptop", new BigDecimal("1299.99"), "Electronics", "High-performance gaming laptop", "http://example.com/laptop.jpg"),
            new Product(2L, "Wireless Mouse", new BigDecimal("49.99"), "Electronics", "Ergonomic wireless mouse", "http://example.com/mouse.jpg"),
            new Product(3L, "Mechanical Keyboard", new BigDecimal("89.99"), "Electronics", "RGB mechanical keyboard", "http://example.com/keyboard.jpg"),
            new Product(4L, "Noise Cancelling Headphones", new BigDecimal("199.99"), "Electronics", "Premium noise cancelling headphones", "http://example.com/headphones.jpg"),
            new Product(5L, "Yoga Mat", new BigDecimal("29.99"), "Fitness", "Non-slip yoga mat", "http://example.com/yogamat.jpg"),
            new Product(6L, "Dumbbell Set", new BigDecimal("59.99"), "Fitness", "Adjustable dumbbell set", "http://example.com/dumbbells.jpg"),
            new Product(7L, "Coffee Maker", new BigDecimal("79.99"), "Home", "Programmable coffee maker", "http://example.com/coffee.jpg"),
            new Product(8L, "Air Purifier", new BigDecimal("129.99"), "Home", "HEPA air purifier", "http://example.com/airpurifier.jpg")
    ));

    public List<Product> findAll() {
        return new ArrayList<>(products);
    }

    public Optional<Product> findById(Long id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    public List<Product> findByCategory(String category) {
        return products.stream()
                .filter(p -> p.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }
}
