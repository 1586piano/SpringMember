package com.example.memberweb.config;

import com.example.memberweb.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

//Autowired를 이용해서 Service, Repository 등의 컴포넌트에 연결할 수 있지만, Configuration을 이용해서 직접 빈 객체를 등록하여 연결시킬 수 있다.
//스프링부트가 실행될 때, @Configuration을 먼저 읽어서 빈을 등록하게 된다.
@Configuration
public class Config {

    private final MemberMapper memberMapper;

    @Autowired//생성자가 하나인 경우, 생략 가능
    public Config(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }


}
