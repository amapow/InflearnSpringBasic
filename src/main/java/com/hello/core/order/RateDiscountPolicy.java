package com.hello.core.order;

import com.hello.core.member.Grade;
import com.hello.core.member.Member;
import org.springframework.stereotype.Component;

@Component
public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int itemPrice) {
       if (member.getGrade() == Grade.VIP) {
           return itemPrice * discountPercent / 100;
       } else {
           return 0;
       }
    }
}
