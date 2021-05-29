package com.example.memberweb.mapper;

import com.example.memberweb.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMapper extends JpaRepository<Member, Long>, MemberMapper{
    @Override
    Optional<Member> findByName(String name);

    @Override
    void saveMember(Member member);
}
