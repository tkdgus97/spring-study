package com.tkdgus.springstudy.service;

import com.tkdgus.springstudy.domain.Member;
import com.tkdgus.springstudy.domain.Order;
import com.tkdgus.springstudy.repository.MemerRepository;
import com.tkdgus.springstudy.repository.MemoryMeberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemerRepository memerRepository = new MemoryMeberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order orderAdd(Long memberId, String itemName, int itemPrice) {
        Member m = memerRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(m, itemPrice);

        return new Order(1L,itemName, m, itemPrice, discountPrice);
    }
}
