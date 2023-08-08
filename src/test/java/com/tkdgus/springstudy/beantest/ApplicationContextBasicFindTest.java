package com.tkdgus.springstudy.beantest;

import static org.junit.jupiter.api.Assertions.assertThrows;

import com.tkdgus.springstudy.AppConfig;
import com.tkdgus.springstudy.service.MemberService;
import com.tkdgus.springstudy.service.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);


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
}
