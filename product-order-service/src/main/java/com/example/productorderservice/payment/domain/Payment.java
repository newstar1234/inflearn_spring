package com.example.productorderservice.payment.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.util.Assert;

import com.example.productorderservice.order.domain.Order;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Order order;

    private String cardNumber;

    public Payment(final Order order, final String cardNumber) {
        Assert.notNull(order, "주문은 필수입니다.");
        Assert.hasText(cardNumber, "카드번호는 필수입니다.");
        this.order = order;
        this.cardNumber = cardNumber;
    }

    public int getPrice() {
        return order.getTotalPrice();
    }

}