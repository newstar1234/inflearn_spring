package com.example.productorderservice.order;

import lombok.AccessLevel;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;
import org.springframework.util.Assert;

import com.example.productorderservice.product.Product;

import lombok.NoArgsConstructor;

@Entity
@Table(name = "orders")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
class Order {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Product product;
    
    private int quantity;

    public Order(final Product product, final int quantity){
        Assert.notNull(product, "상품은 필수입니다.");
        Assert.isTrue(quantity > 0, "수량은 0보다 커야합니다.");
        this.product = product;
        this.quantity = quantity;
    }
}