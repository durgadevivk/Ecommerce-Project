package com.project.ecommerce.service;

import com.project.ecommerce.entity.Cart;
import com.project.ecommerce.entity.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;


public interface CartService {
    public List<Cart> findAll();
    public void addToCart(int productId, int quantity);
    public BigDecimal calculateTotalPrice();
    public void remove(int id);

}
