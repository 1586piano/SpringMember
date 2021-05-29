package com.example.memberweb.mapper;

import com.example.memberweb.domain.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface MemberMapper {
    void saveMember(Member member);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
