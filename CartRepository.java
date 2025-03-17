package com.project.ecommerce.dao;

import com.project.ecommerce.entity.Cart;
import com.project.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Integer> {

    Optional<Cart> findByProduct_id(Product product_id);
}
