package com.example.productorderservice.product;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // private Map<Long, Product> persistence = new HashMap<>();

    // private Long sequence = 0L;

    // public void save(final Product product) {
    //     product.assingId(++sequence);
    //     persistence.put(product.getId(), product);
    // }
    
}
