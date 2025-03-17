package com.project.ecommerce.service;

import com.project.ecommerce.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAll();
    Optional<Product> getProductById(int id);
    List<Product> getProductsByCategory(String category);

    Optional<Product> findById(int productId);
}
