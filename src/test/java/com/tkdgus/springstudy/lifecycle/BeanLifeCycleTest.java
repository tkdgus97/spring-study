package com.tkdgus.springstudy.lifecycle;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

class BeanLifeCycleTest {

    //스프링 빈은 객체 생성 -> 의존 관계 주입 이라는 라이프 사이클을 가진다(setter 주입, 어노테이션 주입)

    /**
     * 스프링 빈의 이벤트 라이프 사이클 : 스프링 컨테이너 생성 -> 스프링 빈 생성 -> 
     * 의존관계 주입 -> 초기화 콜백 -> 사용 -> 소멸전 콜백 -> 스프링 종료
     */

    /**
     * 객체의 생성과 초기화는 가급적 분리하는게 좋다.
     * 생성을 해놓고 요청이 오면 그때 초기화를 할 수 있다는 장점이 있음
     */

    @Test
    public void lcTest() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(BlcConfig.class);
        NetworkClient client = ac.getBean(NetworkClient.class);
        ac.close();
    }

    @Configuration
    static class BlcConfig {

//        @Bean(initMethod = "init", destroyMethod = "close")
        @Bean
        public NetworkClient networkClient() {
            NetworkClient nc = new NetworkClient();
            nc.setUri("http://test-spring.com");
            return nc;
        }
    }
}