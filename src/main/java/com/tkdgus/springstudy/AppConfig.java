package com.tkdgus.springstudy;

import com.tkdgus.springstudy.repository.MemoryMeberRepository;
import com.tkdgus.springstudy.service.FixDiscountPolicy;
import com.tkdgus.springstudy.service.MemberService;
import com.tkdgus.springstudy.service.MemberServiceImpl;
import com.tkdgus.springstudy.service.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMeberRepository());
    }

    public OrderServiceImpl orderService() {
        return new OrderServiceImpl(new MemoryMeberRepository(), new FixDiscountPolicy());
    }
}
