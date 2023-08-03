package com.tkdgus.springstudy.service;

import com.tkdgus.springstudy.domain.Grade;
import com.tkdgus.springstudy.domain.Member;
import com.tkdgus.springstudy.domain.Order;
import com.tkdgus.springstudy.repository.MemerRepository;
import com.tkdgus.springstudy.repository.MemoryMeberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class OrderServiceTest {
    MemerRepository memerRepository = new MemoryMeberRepository();
    OrderService orderService = new OrderServiceImpl(null, null);

    @Test
    void orderAdd() {
        //given
        Member m = new Member(1L, "test", Grade.VIP);
        memerRepository.save(m);

        //when
        Order o = orderService.orderAdd(m.getId(), "상품1", 1500);

        //then
        Assertions.assertThat(o.getDiscountPrice()).isEqualTo(1000);
    }
}