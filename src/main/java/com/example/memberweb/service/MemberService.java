package com.example.memberweb.service;

import com.example.memberweb.domain.Member;
import com.example.memberweb.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberMapper memberMapper;

    @Autowired
    public MemberService(MemberMapper memberMapper){
        this.memberMapper = memberMapper;
    }

    //회원 가입
    public Long join(Member member){
        validateDuplicateMember(member);
        memberMapper.saveMember(member);
        return member.getId();
    }

    //중복 확인
    private void validateDuplicateMember(Member member) {
        Optional<Member> result = memberMapper.findByName(member.getName());
        result.ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

    //전체 회원 조회
    public List<Member> findMembers(){
        return memberMapper.findAll();
    }

    //회원 조회
    public Optional<Member> findMember(String memberName){
        return memberMapper.findByName(memberName);
    }

}
