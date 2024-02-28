package com.hello.springhello.repository;

import java.util.List;
import java.util.Optional;

import com.hello.springhello.domain.Member;

import jakarta.persistence.EntityManager;

public class JpaMemberRepository implements MemberRepository {
    
    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    public Optional<Member> findByName(String name) {
        List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
            .setParameter("name", name)
            .getResultList();
        return result.stream().findAny();
    }

    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
        .getResultList();
    }
    
}
