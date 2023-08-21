package com.tkdgus.springstudy.service;

import com.tkdgus.springstudy.domain.Member;
import com.tkdgus.springstudy.domain.Order;
import com.tkdgus.springstudy.repository.MemerRepository;
import com.tkdgus.springstudy.repository.MemoryMeberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {

    private final MemerRepository memerRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemerRepository memerRepository, DiscountPolicy discountPolicy) {
        this.memerRepository = memerRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order orderAdd(Long memberId, String itemName, int itemPrice) {
        Member m = memerRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(m, itemPrice);

        return new Order(1L,itemName, m, itemPrice, discountPrice);
    }
}
