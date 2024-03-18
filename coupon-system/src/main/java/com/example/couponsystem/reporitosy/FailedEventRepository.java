package com.example.couponsystem.reporitosy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.couponsystem.domain.FailedEvent;

public interface FailedEventRepository extends JpaRepository<FailedEvent, Long> {
    
}
