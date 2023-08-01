package com.tkdgus.springstudy.service;

import com.tkdgus.springstudy.domain.Member;

public interface MemberService {
    void addMember(Member member);

    Member findMember(Long id);
}
