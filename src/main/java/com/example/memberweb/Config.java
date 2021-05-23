package com.example.memberweb;

import com.example.memberweb.repository.MemberRepository;
import com.example.memberweb.repository.MemoryMemberRepository;
import com.example.memberweb.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//Autowired를 이용해서 Service, Repository 등의 컴포넌트에 연결할 수 있지만, Configuration을 이용해서 직접 빈 객체를 등록하여 연결시킬 수 있다.
//스프링부트가 실행될 때, @Configuration을 먼저 읽어서 빈을 등록하게 된다.
@Configuration
public class Config {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
