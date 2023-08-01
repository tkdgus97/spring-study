package com.tkdgus.springstudy.domain;

public interface MemerRepository {
    Long save(Member member);

    Member findById(Long id);
}
