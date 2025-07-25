package com.example.API_Rest.controller;

import com.example.API_Rest.model.Product;
import com.example.API_Rest.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> listProduct() {
        return productService.listProduct();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> searchProduct(@PathVariable Long id) {
        Product product = productService.searchById(id);
        return ResponseEntity.ok(product);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delProduct(@PathVariable Long id) {
        productService.delProduct(id);
        return ResponseEntity.noContent().build();
    }
}
