package com.project.ecommerce.ExceptionHandler;

public class ProductGlobalException extends RuntimeException {

    public ProductGlobalException(String message) {
        super(message);
    }
    public ProductGlobalException() {
        super("A product-related error occurred.");
    }
}
