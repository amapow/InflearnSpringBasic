package com.hello.core.order;

import com.hello.core.member.Member;

public interface DiscountPolicy {

    int discount(Member member, int itemPrice);

}
