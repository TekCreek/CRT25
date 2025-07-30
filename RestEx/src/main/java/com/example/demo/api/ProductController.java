package com.example.demo.api;

import com.example.demo.entity.Product;
import com.example.demo.model.ProductSearch;
import com.example.demo.service.ProductService;
import com.example.demo.service.ServiceLayerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.findAll();
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.save(product);
    }

    @PostMapping("/find")
    public List<Product> findProducts(@RequestBody ProductSearch productSearch) {
        return productService.findProducts(productSearch);

    }

    @PutMapping
    public ResponseEntity<?> updateProduct(@RequestBody Product product) {
        try {
            return ResponseEntity.ok(productService.update(product));
        } catch (ServiceLayerException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") long productId) {
        try {
            productService.delete(productId);
            return ResponseEntity.ok("Product deleted");
        } catch (ServiceLayerException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}
