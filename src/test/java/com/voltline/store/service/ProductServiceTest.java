package com.voltline.store.service;

import com.voltline.store.domain.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceTest {

    private ProductService productService;

    @BeforeEach
    void setUp() {
        productService = new ProductService();
    }

    @Test
    void findAll_ShouldReturnAllProducts() {
        List<Product> products = productService.findAll();
        assertNotNull(products);
        assertEquals(8, products.size(), "Should return all 8 hardcoded products");
    }

    @Test
    void findById_ShouldReturnProductWhenIdExists() {
        Long existingId = 1L;
        Optional<Product> product = productService.findById(existingId);
        assertTrue(product.isPresent(), "Product should be present for ID 1");
        assertEquals("Gaming Laptop", product.get().getName());
    }

    @Test
    void findById_ShouldReturnEmptyWhenIdDoesNotExist() {
        Long nonExistingId = 999L;
        Optional<Product> product = productService.findById(nonExistingId);
        assertFalse(product.isPresent(), "Product should not be present for ID 999");
    }

    @Test
    void findByCategory_ShouldReturnProductsOfSpecifiedCategory() {
        String category = "Electronics";
        List<Product> electronics = productService.findByCategory(category);
        assertNotNull(electronics);
        assertFalse(electronics.isEmpty());
        assertTrue(electronics.stream().allMatch(p -> p.getCategory().equalsIgnoreCase(category)));
    }

    @Test
    void findByCategory_ShouldBeCaseInsensitive() {
        String category = "electronics";
        List<Product> electronics = productService.findByCategory(category);
        assertNotNull(electronics);
        assertFalse(electronics.isEmpty());
        assertTrue(electronics.stream().allMatch(p -> p.getCategory().equalsIgnoreCase(category)));
    }

    @Test
    void findByCategory_ShouldReturnEmptyListForUnknownCategory() {
        String category = "Books";
        List<Product> books = productService.findByCategory(category);
        assertNotNull(books);
        assertTrue(books.isEmpty(), "Should return an empty list for a category that does not exist");
    }
}
