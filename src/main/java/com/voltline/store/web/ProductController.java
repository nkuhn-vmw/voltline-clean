package com.voltline.store.web;

import com.voltline.store.domain.Product;
import com.voltline.store.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@Controller
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product/{id}")
    public String getProductDetail(@PathVariable Long id, Model model) {
        return productService.findById(id)
                .map(product -> {
                    model.addAttribute("product", product);
                    return "product-detail";
                })
                .orElseGet(() -> {
                    // Return 404 view or set status. 
                    // Using a simple "error/404" or similar is common, 
                    // but since the task says "return a 404 view (or set 404 status)",
                    // I'll use a custom ResponseStatus exception or a dedicated view.
                    // For simplicity and following typical Spring MVC patterns in clean repos,
                    // I'll return a view name "error/404" or let Spring handle it.
                    // However, a safer bet for "set 404 status" without a dedicated view is 
                    // using ResponseStatusException.
                    throw new org.springframework.web.server.ResponseStatusException(HttpStatus.NOT_FOUND);
                });
    }
}
