package com.Application.pharmacy.controller;

import com.Application.pharmacy.model.Product;
import com.Application.pharmacy.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
 @Autowired

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping
    public List<Product> getAllProducts() {
     return productService.getAllProducts();
    }
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable long id) {
     return productService.getProductById(id).orElseThrow();
    }
    @PostMapping
    public Product addProduct(@RequestBody Product product) {
     return productService.addProduct(product);
    }
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable long id, @RequestBody Product product) {
     return productService.updateProductbyid(id, product);
    }
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable long id) {
     productService.deleteProduct(id);
    }
}
