package com.example.Assignment.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Assignment.Entity.Product;
import com.example.Assignment.Services.ProductService;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Get All Products
    @GetMapping
    public List<Product> getAllProducts() {
        return this.productService.GetAllProduct();
    }

    // Get Single Product By Id
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return this.productService.GetProduct(id);
    }

    // Create A Product
    @PostMapping("{categoryId}")
    public Product createProduct(@RequestBody Product product, @PathVariable Long categoryId) {
    	  Product createdProduct = productService.createProduct(product, categoryId);
        return this.productService.createProduct(product,categoryId);
    }

    // Update a Product
    @PutMapping("/{id}")
    public Product updateProduct(@RequestBody Product prod, @PathVariable Long id) {
        return this.productService.UpdateProduct(prod, id);
    }

    // Delete a Product
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        this.productService.DeleteProduct(id);
    }
}
