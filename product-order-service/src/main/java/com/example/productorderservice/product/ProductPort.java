package com.example.productorderservice.product;

interface ProductPort {
    void save(final Product product);

    Product getProduct(Long produntId);
}