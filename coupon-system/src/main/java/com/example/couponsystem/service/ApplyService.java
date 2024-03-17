package com.example.couponsystem.service;

import org.springframework.stereotype.Service;

import com.example.couponsystem.domain.Coupon;
import com.example.couponsystem.producer.CouponCreateProducer;
import com.example.couponsystem.reporitosy.CouponCountRepository;
import com.example.couponsystem.reporitosy.CouponRepository;

@Service
public class ApplyService {
    
    private final CouponRepository couponRepository;

    private final CouponCountRepository couponCountRepository; // redis - incr 사용

    private final CouponCreateProducer couponCreateProducer; // kafka 사용

    public ApplyService(CouponRepository couponRepository, CouponCountRepository couponCountRepository, CouponCreateProducer couponCreateProducer) {
        this.couponRepository = couponRepository;
        this.couponCountRepository = couponCountRepository;
        this.couponCreateProducer = couponCreateProducer;
    }

    public void apply(Long userId) {
        // long count = couponRepository.count();
        Long count = couponCountRepository.incrment(); //redis-incr 

        if(count > 100) {
            return;
        }

        // couponRepository.save(new Coupon(userId));
        couponCreateProducer.create(userId);
    }

}
