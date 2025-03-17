package com.project.ecommerce.service;

import com.project.ecommerce.dao.CartRepository;
import com.project.ecommerce.dao.ProductRepository;
import com.project.ecommerce.entity.Cart;
import com.project.ecommerce.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartServImp implements CartService{


    @Autowired
   private CartRepository cartRepository;
    @Autowired
   private ProductRepository productRepository;

    public CartServImp(CartRepository cartRepository, ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }

    @Override
    public List<Cart> findAll() {return cartRepository.findAll();}

    @Override
    public void addToCart(int productId, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero.");
        }

        // Retrieve the product
        Optional<Product> productOptional = productRepository.findById(productId);
        if (productOptional.isEmpty()) {
            throw new IllegalArgumentException("Product with ID " + productId + " not found.");
        }

        Product product = productOptional.get();
        BigDecimal productPrice = new BigDecimal(String.valueOf(product.getPrice()));

        // Check if the product already exists in the cart
        Optional<Cart> existingCartItem = cartRepository.findById(productId);
        if (existingCartItem.isPresent()) {
            Cart cartItem = existingCartItem.get();
            cartItem.setQuantity(cartItem.getQuantity() + quantity);
            cartItem.setTotalPrice(productPrice.multiply(BigDecimal.valueOf(cartItem.getQuantity())));
            cartRepository.save(cartItem);
        } else {
            Cart newCartItem = new Cart();
            newCartItem.setProduct(product);
            newCartItem.setQuantity(quantity);
            newCartItem.setTotalPrice(productPrice.multiply(BigDecimal.valueOf(quantity)));
            cartRepository.save(newCartItem);
        }
    }

    @Override
    public BigDecimal calculateTotalPrice() {
        return cartRepository.findAll().stream()
                .map(cart -> {
                    Product product = productRepository.findById(cart.getProduct().getId())
                            .orElseThrow(() -> new RuntimeException("Product not found for Cart ID: " + cart.getId()));
                    return BigDecimal.valueOf(cart.getQuantity())
                            .multiply(product.getPrice());
                })
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public void remove(int id) {
        cartRepository.deleteById(id);
    }
}
