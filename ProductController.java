package com.project.ecommerce.controller;

import com.project.ecommerce.ExceptionHandler.ProductGlobalException;
import com.project.ecommerce.entity.Product;
import com.project.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api")
public class ProductController {

    @Autowired
private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // GET /products - To fetch all products
    @GetMapping("/products")
    public String getAllProducts(@RequestParam(required = false) String category, Model model) {
        List<Product> products;
        if (category != null && !category.isEmpty()) {
            products = productService.getProductsByCategory(category);
        } else {
            products = productService.findAll();
        }
        model.addAttribute("products", products);
        return "products";
    }
    // GET /products/{id} - To fetch product details by ID
    @GetMapping("/products/{id}")
    public String getProductById(@PathVariable int id, Model model) {
        Optional<Product> product = productService.getProductById(id);
        if (product.isPresent()) {
            model.addAttribute("product", product.get());
            return "product-detail"; // Thymeleaf template for displaying product details
        } else {
            throw new ProductGlobalException("Product with ID " + id + " not found.");

        }
    }

    // GET /products?category={category} - To filter products by category
    @GetMapping("/products/category/{category}") // "params = "category")
    public String getProductsByCategory(@RequestParam String category, Model model) {
        List<Product> products = productService.getProductsByCategory(category);
        model.addAttribute("products", products);
        return "products"; // Reusing the product list template
    }
}
