package com.project.ecommerce.service;

import com.project.ecommerce.ExceptionHandler.ProductGlobalException;
import com.project.ecommerce.dao.ProductRepository;
import com.project.ecommerce.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductSerImp implements ProductService {
@Autowired
    private ProductRepository productRepository;

    public ProductSerImp(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public List<Product> findAll() {
        return productRepository.findAll().stream()
                .filter(product -> product != null)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Product> getProductById(int id) {

        return productRepository.findById(id);
}

    @Override
    public List<Product> getProductsByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    @Override
    public Optional<Product> findById(int productId) {
        Optional<Product> pro = productRepository.findById(productId);
        if (pro.isPresent()) {
            return pro;
        } else {
            throw new ProductGlobalException("Product with ID " + productId + " not found.");
        }
    }
}
