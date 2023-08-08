package com.tkdgus.springstudy.service;

import com.tkdgus.springstudy.domain.Member;

public class RateDiscountPolicy implements DiscountPolicy{

    @Override
    public int discount(Member member, int price) {
        return 0;
    }
}
