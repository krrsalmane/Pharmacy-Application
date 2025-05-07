package com.Application.pharmacy.service;

import com.Application.pharmacy.model.Product;
import com.Application.pharmacy.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    @Autowired

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    public Optional<Product> getProductById(long id) {
        return productRepository.findById(id);
    }
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }
    public void deleteProduct(long id) {
        productRepository.deleteById(id);
    }
    public Product updateProductbyid(long id, Product productdetaill) {
        Product product = productRepository.findById(id).orElseThrow();
        product.setDescription(productdetaill.getDescription());
        product.setName(productdetaill.getName());
        product.setPrice(productdetaill.getPrice());
        return productRepository.save(product);
    }
}
