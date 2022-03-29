package com.hello.core.order;

import com.hello.core.AppConfig;
import com.hello.core.member.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Bean;

public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void order() {
        long memberId = 1L;
        //given
        Member memberA = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(memberA);

        //when
        orderService.createOrder(memberA.getId(), "coffee", 5000);

        //then
        Assertions.assertThat(1000).isEqualTo(orderService.createOrder(memberA.getId(), "coffee", 10000).getDiscountPrice());

    }
}