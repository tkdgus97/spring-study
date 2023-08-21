package com.tkdgus.springstudy.beantest;

import com.tkdgus.springstudy.repository.MemerRepository;
import com.tkdgus.springstudy.repository.MemoryMeberRepository;
import com.tkdgus.springstudy.service.DiscountPolicy;
import com.tkdgus.springstudy.service.FixDiscountPolicy;
import com.tkdgus.springstudy.service.RateDiscountPolicy;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class ExtendsFindTest {

    ApplicationContext ac = new AnnotationConfigApplicationContext(SameConfig.class);

    @Test
    @DisplayName("object class 조회 시 나오는 bean 출력")
    void findAllByObject() {
        Map<String, Object> beans = ac.getBeansOfType(Object.class);
        for (String s : beans.keySet()) {
            System.out.println("key == " + s + "value == " + beans.get(s));
        }
    }

    @Configuration
    static class SameConfig {

        @Bean
        public DiscountPolicy discountPolicy1() {
            return new FixDiscountPolicy();
        }

        @Bean
        public DiscountPolicy discountPolicy2() {
            return new RateDiscountPolicy();
        }
    }
}
