package com.example.memberweb.repository;

import com.example.memberweb.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    //하나의 Test가 끝날 때마다 실행됨.
    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("song");
        member.setPw("hee");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        Assertions.assertEquals(member, result);
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        Member member2 = new Member();

        member1.setName("song");
        member1.setPw("song");

        member2.setName("hee");
        member2.setPw("hee");

        repository.save(member1);
        repository.save(member2);

        Member result = repository.findByName("song").get();
        //Assertions.assertEquals(member1, result);
        Assertions.assertEquals(member2, result);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        Member member2 = new Member();

        member1.setName("song");
        member1.setPw("song");

        member2.setName("hee");
        member2.setPw("hee");

        repository.save(member1);
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }
}
