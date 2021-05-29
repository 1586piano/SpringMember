package com.example.memberweb.service;


import mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    private final MemberMapper memberMapper;

    @Autowired
    public SpringConfig(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }
    @Bean
    public MemberService memberService() {
        return new MemberService(memberMapper);
    }
}