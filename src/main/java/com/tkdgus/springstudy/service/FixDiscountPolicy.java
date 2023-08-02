package com.tkdgus.springstudy.service;

import com.tkdgus.springstudy.domain.Grade;
import com.tkdgus.springstudy.domain.Member;

public class FixDiscountPolicy implements DiscountPolicy {

    private final int DISCOUNT_AMOUNT = 1000;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return DISCOUNT_AMOUNT;
        }
        return 0;
    }
}
