package com.example.memberweb.mapper;

import com.example.memberweb.domain.Member;

import java.util.*;

public class MemberMapperImpl implements MemberMapper {

    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void saveMember(Member member) {
    }

    @Override
    public Optional<Member> findByName(String name) {  //null인 경우 감싸서 반환
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }

}
