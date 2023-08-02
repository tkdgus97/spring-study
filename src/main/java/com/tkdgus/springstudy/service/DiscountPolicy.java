package com.tkdgus.springstudy.service;

import com.tkdgus.springstudy.domain.Member;

public interface DiscountPolicy {
    int discount(Member member, int price);
}
