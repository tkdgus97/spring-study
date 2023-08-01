package com.tkdgus.springstudy;

import com.tkdgus.springstudy.domain.Grade;
import com.tkdgus.springstudy.domain.Member;
import com.tkdgus.springstudy.service.MemberService;
import com.tkdgus.springstudy.service.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member memberA = new Member(1L, "memberA", Grade.VIP);

        memberService.addMember(memberA);

        Member findMember = memberService.findMember(1L);
    }
}
