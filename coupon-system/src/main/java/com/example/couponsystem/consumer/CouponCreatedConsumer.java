package com.example.couponsystem.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.example.couponsystem.domain.Coupon;
import com.example.couponsystem.domain.FailedEvent;
import com.example.couponsystem.reporitosy.CouponRepository;
import com.example.couponsystem.reporitosy.FailedEventRepository;

@Component
public class CouponCreatedConsumer {

    private final CouponRepository couponRepository;

    private final FailedEventRepository failedEventRepository;

    private final Logger logger = LoggerFactory.getLogger(CouponCreatedConsumer.class);

    public CouponCreatedConsumer(CouponRepository couponRepository, FailedEventRepository failedEventRepository) {
        this.couponRepository = couponRepository;
        this.failedEventRepository = failedEventRepository;
    }
     
    @KafkaListener(topics = "coupon_create", groupId = "group_1")
    public void listener(Long userId) {

        try {
            couponRepository.save(new Coupon(userId));
        } catch (Exception exception) {
            logger.error("failed to create coupon::" + userId);
            failedEventRepository.save(new FailedEvent(userId));
        }
    }

}
