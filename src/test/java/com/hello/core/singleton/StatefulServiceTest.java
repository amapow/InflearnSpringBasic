package com.hello.core.singleton;

import com.hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleTon() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);
        //ThreadA: A 사용자 10000원 주문
        int userAprice = statefulService1.order("userA", 10000);

        //ThreadB: B 사용자 20000원 주문
        int userBprice = statefulService2.order("userB", 20000);

        System.out.println("userAprice = " + userAprice);

        //ThreadA: 사용자A가 주문 금액 조회
//        System.out.println(statefulService1.order());
//
//        Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);
    }

    static class TestConfig {

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}