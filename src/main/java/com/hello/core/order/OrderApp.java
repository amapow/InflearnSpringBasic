package com.hello.core.order;

import com.hello.core.AppConfig;
import com.hello.core.member.Grade;
import com.hello.core.member.Member;
import com.hello.core.member.MemberService;
import com.hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

    public static void main(String[] args) {

//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        OrderService orderService = ac.getBean("orderService", OrderService.class);

//        MemberService memberService = new MemberServiceImpl(appConfig.memberService());
//        OrderService orderService = new OrderServiceImpl(null, null);

        Member memberA = new Member(1L, "memberA", Grade.VIP);

        memberService.join(memberA);
        System.out.println(orderService.createOrder(memberA.getId(), "커피", 20000));
    }
}
