package com.example.coupon_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.coupon_system.domain.Coupon;

public interface CouponRepository extends JpaRepository<Coupon, Long> {
    
}
