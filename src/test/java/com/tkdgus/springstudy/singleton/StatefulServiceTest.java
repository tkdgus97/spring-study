package com.tkdgus.springstudy.singleton;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

class StatefulServiceTest {
    @Test
    void statefulServiceTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService s1 = ac.getBean(StatefulService.class);
        StatefulService s2 = ac.getBean(StatefulService.class);

        //요청 1
        s1.order("반바지", 12000);
        //요청 2
        s2.order("반팔", 5000);

        //요청 1의 가격 조회 시 12000원이 나와야 하지만 5000이 적용됨 
        //이유 : 클라이언트가 상태를 변경하기 때문 즉 싱글톤 객체 설계시 상태를 변경시킬 수 있는 필드와 코드가 존재하기 때문
        Assertions.assertThat(s1.getPrice()).isEqualTo(5000);

    }

    @Configuration
    static class TestConfig {
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}