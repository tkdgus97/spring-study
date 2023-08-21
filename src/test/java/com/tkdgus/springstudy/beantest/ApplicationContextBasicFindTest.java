package com.tkdgus.springstudy.beantest;

import static org.junit.jupiter.api.Assertions.assertThrows;

import com.tkdgus.springstudy.AppConfig;
import com.tkdgus.springstudy.AutoAppConfig;
import com.tkdgus.springstudy.repository.MemerRepository;
import com.tkdgus.springstudy.repository.MemoryMeberRepository;
import com.tkdgus.springstudy.service.MemberService;
import com.tkdgus.springstudy.service.MemberServiceImpl;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.convert.DurationFormat;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameConfig.class);


    @Test
    @DisplayName("bean 이름으로 조회")
    void findApplicationBean() {
        MemberService ms = ac.getBean("memberService", MemberService.class);

        Assertions.assertThat(ms.getClass()).isEqualTo(MemberServiceImpl.class);
    }

    //실패 테스트
    @Test
    @DisplayName("bean 조회 실패")
    void failFindBeanByName() {
        assertThrows(NoSuchBeanDefinitionException.class,
            () -> ac.getBean("xxxx", MemberService.class));
    }

    @Test
    @DisplayName("타입으로 조회 시 같은 타입의 Bean이 둘 이상이면 중복 오류가 발생")
    void findBeanDuplicate(){
        assertThrows(NoUniqueBeanDefinitionException.class,
            () -> ac.getBean(MemerRepository.class));
    }

    @Test
    @DisplayName("특정 타입의 빈 모두 조회")
    void findAllBeanByType() {
        Map<String, MemerRepository> beans = ac.getBeansOfType(MemerRepository.class);

        for (String key : beans.keySet()) {
            System.out.println("key == " + key + " value == " + beans.get(key));
        }
    }

    @Test
    @DisplayName("componentscan을 통한 bean 설정 및 조회")
    void componentBeanFind() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        MemberService m = ac.getBean(MemberService.class);
        MemberService m2 = ac.getBean(MemberService.class);
        AutoAppConfig appConfig = ac.getBean(AutoAppConfig.class);
        System.out.println(appConfig);
        System.out.println(m);
        System.out.println(m2);
    }

    @Configuration
    static class SameConfig {

        @Bean
        public MemerRepository memerRepository1() {
            return new MemoryMeberRepository();
        }

        @Bean
        public MemerRepository memerRepository2() {
            return new MemoryMeberRepository();
        }
    }
}
