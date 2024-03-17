package com.example.couponsystem.service;

import org.springframework.stereotype.Service;

import com.example.couponsystem.domain.Coupon;
import com.example.couponsystem.reporitosy.CouponCountRepository;
import com.example.couponsystem.reporitosy.CouponRepository;

@Service
public class ApplyService {
    
    private final CouponRepository couponRepository;

    private final CouponCountRepository couponCountRepository; // redis - incr 사용

    public ApplyService(CouponRepository couponRepository, CouponCountRepository couponCountRepository) {
        this.couponRepository = couponRepository;
        this.couponCountRepository = couponCountRepository;
    }

    public void apply(Long userId) {
        // long count = couponRepository.count();
        Long count = couponCountRepository.incrment(); //redis-incr

        if(count > 100) {
            return;
        }

        couponRepository.save(new Coupon(userId));
    }

}
