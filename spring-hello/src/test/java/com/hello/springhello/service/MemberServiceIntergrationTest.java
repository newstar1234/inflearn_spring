package com.hello.springhello.service;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import com.hello.springhello.domain.Member;
import com.hello.springhello.repository.MemberRepository;
import com.hello.springhello.repository.MemoryMemberRepository;

@SpringBootTest
@Transactional // 테스트 케이스에 이 어노테이션 -> 테스트 시작 전에 트랜잭션 시작하고 테스트 끝나고 롤백해줌
public class MemberServiceIntergrationTest {
    
    // 통합 테스트

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Test
    @Commit
    void 회원가입() {
        // given
        Member member = new Member();
        member.setName("spring");

        // when
        Long saveId = memberService.join(member);

        // then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외() {
        // given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        // when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

        // try {
        //     memberService.join(member2);
        //     fail("예외 발생");
        // } catch (IllegalStateException exception) {
        //     assertThat(exception.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        // }

        // then
    }


}
