package com.tkdgus.springstudy.service;

import com.tkdgus.springstudy.domain.Order;

public interface OrderService {
    Order orderAdd(Long memberId, String itemName, int itemPrice);
}
