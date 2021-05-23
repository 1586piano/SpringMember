package com.example.memberweb.service;

import com.example.memberweb.domain.Member;
import com.example.memberweb.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MemberServiceTest {

    MemoryMemberRepository memberRepository;
    MemberService memberService;

    @BeforeEach()
    void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    void AfterEach(){
        memberRepository.clearStore();
    }


    @Test
    void join(){
        //given
        Member member = new Member();
        member.setName("song");
        member.setPw("song");

        //when
        Long saveId =memberService.join(member);

        //then
        Member findMember = memberService.findMember(saveId).get();
        Assertions.assertThat(findMember.getName()).isEqualTo(member.getName());
    }

    @Test
   public void duplicatedMember() throws Exception{
        //given
        Member member1 = new Member();
        member1.setName("song");
        member1.setPw("song");

        Member member2 = new Member();
        member2.setName("song");
        member2.setPw("song");

        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }

    @Test
    void findMembers(){

    }

    @Test
    void findMember(){

    }

}
