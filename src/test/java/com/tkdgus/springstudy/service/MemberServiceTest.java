package com.tkdgus.springstudy.service;

import com.tkdgus.springstudy.domain.Grade;
import com.tkdgus.springstudy.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl(null);

    @Test
    void addMember() {
        Member member = new Member(1L, "memberA", Grade.GENERAL);

        memberService.addMember(member);

        Member findMember = memberService.findMember(1L);

        Assertions.assertThat(member).isEqualTo(findMember);
    }

}