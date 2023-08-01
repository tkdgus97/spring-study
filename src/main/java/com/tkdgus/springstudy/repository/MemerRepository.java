package com.tkdgus.springstudy.repository;

import com.tkdgus.springstudy.domain.Member;

public interface MemerRepository {
    Long save(Member member);

    Member findById(Long id);
}
