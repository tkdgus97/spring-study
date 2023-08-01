package com.tkdgus.springstudy.service;

import com.tkdgus.springstudy.domain.Member;
import com.tkdgus.springstudy.repository.MemoryMeberRepository;

public class MemberServiceImpl implements MemberService{

    private final MemoryMeberRepository memoryMeberRepository = new MemoryMeberRepository();

    @Override
    public void addMember(Member member) {
        memoryMeberRepository.save(member);
    }

    @Override
    public Member findMember(Long id) {
        return memoryMeberRepository.findById(id);
    }
}
