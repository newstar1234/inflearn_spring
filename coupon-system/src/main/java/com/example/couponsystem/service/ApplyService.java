package com.example.couponsystem.service;

import org.springframework.stereotype.Service;

import com.example.couponsystem.domain.Coupon;
import com.example.couponsystem.producer.CouponCreateProducer;
import com.example.couponsystem.reporitosy.AppliedUserRepository;
import com.example.couponsystem.reporitosy.CouponCountRepository;
import com.example.couponsystem.reporitosy.CouponRepository;

@Service
public class ApplyService {
    
    private final CouponRepository couponRepository;

    private final CouponCountRepository couponCountRepository; // redis - incr 사용

    private final CouponCreateProducer couponCreateProducer; // kafka 사용

    private final AppliedUserRepository appliedUserRepository; // redis - 1명당 쿠폰 1개 제한

    public ApplyService(
            CouponRepository couponRepository, 
            CouponCountRepository couponCountRepository, 
            CouponCreateProducer couponCreateProducer,
            AppliedUserRepository appliedUserRepository) {
        this.couponRepository = couponRepository;
        this.couponCountRepository = couponCountRepository;
        this.couponCreateProducer = couponCreateProducer;
        this.appliedUserRepository = appliedUserRepository;
    }

    public void apply(Long userId) {
        // long count = couponRepository.count();

        Long apply = appliedUserRepository.add(userId);

        if(apply != 1) {
            return;
        }

        // lock start
        // 쿠폰 발급 여부
        // if(발급됐다면) return   
        Long count = couponCountRepository.incrment(); //redis-incr 

        if(count > 100) {
            return;
        }

        // couponRepository.save(new Coupon(userId));
        couponCreateProducer.create(userId);
        // 쿠폰 발급
        // lock end
    }

}
