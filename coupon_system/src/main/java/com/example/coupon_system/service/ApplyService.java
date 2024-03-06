package com.example.coupon_system.service;

import org.springframework.stereotype.Service;

import com.example.coupon_system.domain.Coupon;
import com.example.coupon_system.repository.CouponCountRepository;
import com.example.coupon_system.repository.CouponRepository;

@Service
public class ApplyService {
    
    private final CouponRepository couponRepository;

    private final CouponCountRepository couponCountRepository;

    public ApplyService(CouponRepository couponRepository, CouponCountRepository couponCountRepository) {
        this.couponRepository = couponRepository;
        this.couponCountRepository = couponCountRepository;
    }

    public void apply(Long userId) {
        long count = couponCountRepository.increment();

        if(count > 100) {
            return;
        }

        couponRepository.save(new Coupon());
    }

}
