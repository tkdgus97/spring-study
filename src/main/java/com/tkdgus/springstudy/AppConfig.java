package com.tkdgus.springstudy;

import com.tkdgus.springstudy.repository.MemerRepository;
import com.tkdgus.springstudy.repository.MemoryMeberRepository;
import com.tkdgus.springstudy.service.DiscountPolicy;
import com.tkdgus.springstudy.service.MemberService;
import com.tkdgus.springstudy.service.MemberServiceImpl;
import com.tkdgus.springstudy.service.OrderServiceImpl;
import com.tkdgus.springstudy.service.RateDiscountPolicy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//설정 정보 객체
@Configuration
public class AppConfig {

    //bean
    @Bean
    public MemerRepository memerRepository() {
        return new MemoryMeberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memerRepository());
    }

    @Bean
    public OrderServiceImpl orderService() {
        return new OrderServiceImpl(memerRepository(), discountPolicy());
    }
}
