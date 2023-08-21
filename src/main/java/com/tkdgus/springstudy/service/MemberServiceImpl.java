package com.tkdgus.springstudy.service;

import com.tkdgus.springstudy.domain.Member;
import com.tkdgus.springstudy.repository.MemerRepository;
import com.tkdgus.springstudy.repository.MemoryMeberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{

    private final MemerRepository memerRepository;

    @Autowired
    public MemberServiceImpl(MemerRepository memerRepository) {
        this.memerRepository = memerRepository;
    }

    @Override
    public void addMember(Member member) {
        memerRepository.save(member);
    }

    @Override
    public Member findMember(Long id) {
        return memerRepository.findById(id);
    }
}
