package com.example.coupon_system.service;

import static org.assertj.core.api.Assertions.*;
import java.util.concurrent.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.coupon_system.repository.CouponRepository;

@SpringBootTest
public class ApplyServiceTest {
    
    @Autowired
    private ApplyService applyService;

    @Autowired
    private CouponRepository couponRepository;

    @Test
    public void 한번만응모() {
        applyService.apply(1L);

        long count = couponRepository.count();
        
        assertThat(count).isEqualTo(1);
    }

    @Test
    public void 여러명응모() throws InterruptedException {

        int threadCount = 1000;
        ExecutorService executorService = Executors.newFixedThreadPool(32); // 병렬 작업을 간단하게 할수있게 도와주는 자바의 api
        CountDownLatch latch = new CountDownLatch(threadCount); // 다른 스레드에서 수행하는 작업을 기다리도록 도와주는 클래스

        for(int i = 0; i < threadCount; i++) {
            long userId = i;
            executorService.submit(() -> {
                try{
                    applyService.apply(userId);
                } finally {
                    latch.countDown();
                }
            });
        }

        latch.await();

        long count = couponRepository.count();

        assertThat(count).isEqualTo(100);
    }
}
