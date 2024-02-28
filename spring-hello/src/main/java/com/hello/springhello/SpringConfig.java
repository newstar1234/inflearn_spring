package com.hello.springhello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hello.springhello.aop.TimeTraceAop;
import com.hello.springhello.repository.JdbcMemberRepository;
import com.hello.springhello.repository.JdbcTemplateMemberRepository;
import com.hello.springhello.repository.JpaMemberRepository;
import com.hello.springhello.repository.MemberRepository;
import com.hello.springhello.repository.MemoryMemberRepository;
import com.hello.springhello.service.MemberService;

import jakarta.persistence.EntityManager;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    // 스프링 데이터 JPA -> 학원에서 배운거 //
    private final MemberRepository memberRepository;
    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    
    // JPA 학습
    // private EntityManager em;
    // @Autowired
    // public SpringConfig(EntityManager em) {
    //         this.em = em;
    // }
    
    // JDBC 학습
    // private DataSource dataSource;
    // @Autowired
    // public SpringConfig(DataSource dataSource) {
    //     this.dataSource = dataSource;
    // }

    // 자바 코드로 직접 스프링 빈 등록하기 // 
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

    // @Bean
    // public MemberRepository memberRepository() {
        // return new MemoryMemberRepository();
        // return new JdbcMemberRepository(dataSource);
        // return new JdbcTemplateMemberRepository(dataSource);
        // return new JpaMemberRepository(em);
    // }

    // @Bean
    // public TimeTraceAop timeTraceAop () {
    //     return new TimeTraceAop();
    // }
    // AOP 관련 빈 등록 OR @Component 사용해도 무방함!
}
