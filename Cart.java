package com.project.ecommerce.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "cart")
public class Cart {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

@ManyToOne
@JoinColumn(name = "product_id", nullable = false)
    private Product product;
@Column(name = "quantity")
    private int quantity;
    @Column(name = "total_price")
    private BigDecimal totalPrice;

    public Cart() {
    }

    public Cart(Product product, int quantity, BigDecimal totalPrice) {
        this.product = product;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
