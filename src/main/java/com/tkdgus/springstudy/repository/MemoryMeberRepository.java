package com.tkdgus.springstudy.repository;

import com.tkdgus.springstudy.domain.Member;
import com.tkdgus.springstudy.repository.MemerRepository;
import java.util.HashMap;
import java.util.Map;

public class MemoryMeberRepository implements MemerRepository {

    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public Long save(Member member) {
        store.put(member.getId(), member);
        return member.getId();
    }

    @Override
    public Member findById(Long id) {
        return store.get(id);
    }


}
