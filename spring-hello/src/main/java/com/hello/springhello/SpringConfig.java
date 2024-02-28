package com.hello.springhello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
    
    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
            this.em = em;
    }
    
    // private DataSource dataSource;

    // @Autowired
    // public SpringConfig(DataSource dataSource) {
    //     this.dataSource = dataSource;
    // }

    // 자바 코드로 직접 스프링 빈 등록하기 // 
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        // return new MemoryMemberRepository();
        // return new JdbcMemberRepository(dataSource);
        // return new JdbcTemplateMemberRepository(dataSource);
        return new JpaMemberRepository(em);
    }
}
