package hello.springcore.discount;

import hello.springcore.member.Grade;
import hello.springcore.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {
    private int discountFixedAmount = 1000; // VIP 고객에게 적용할 고정 금액 할인

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return discountFixedAmount;
        } else {
            return 0;
        }
    }
}
