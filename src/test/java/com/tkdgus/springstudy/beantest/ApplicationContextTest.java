package com.tkdgus.springstudy.beantest;

import com.tkdgus.springstudy.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 bean 출력")
    void findAllBean() {
        String[] beanNames = ac.getBeanDefinitionNames();
        for (String s : beanNames) {
            Object bean = ac.getBean(s);
            System.out.println("name = " + s + "object = " + bean);
        }
    }

    @Test
    @DisplayName("애플리케이션 bean 출력")
    void findApplicationBean() {
        String[] beanNames = ac.getBeanDefinitionNames();
        for (String s : beanNames) {
            BeanDefinition bean = ac.getBeanDefinition(s);

            //ROLE_APPLICATION : 직접 등록한 어플리케이션 빈(개발자가 만들었다는 의미)
            //ROLE_INFRASTRUCTURE : 스프링이 내부에서 사용하는 빈
            if (bean.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object o = ac.getBean(s);
                System.out.println("name = " + s + "object = " + o);
            }
        }
    }
}
