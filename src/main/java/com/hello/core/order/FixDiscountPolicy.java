package com.hello.core.order;

import com.hello.core.member.Grade;
import com.hello.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("mainDiscountPolicy")
public class FixDiscountPolicy implements DiscountPolicy {

    int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int itemPrice) {
        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        } else return 0;
    }
}
