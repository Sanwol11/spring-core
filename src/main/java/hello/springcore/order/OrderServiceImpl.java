package hello.springcore.order;

import hello.springcore.discount.DiscountPolicy;
import hello.springcore.member.Member;
import hello.springcore.member.MemoryMemberRepository;
public class OrderServiceImpl implements OrderService{
    private final MemoryMemberRepository memoryMemberRepository;
    private final DiscountPolicy discountpolicy;

    public OrderServiceImpl(MemoryMemberRepository memoryMemberRepository , DiscountPolicy discountpolicy) {
        this.memoryMemberRepository = memoryMemberRepository;
        this.discountpolicy = discountpolicy;
    }

    // private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
       Member member = memoryMemberRepository.findById(memberId);
        int discountPrice = discountpolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
/* **회원을 메모리에서 조회하고, 정액(고정금액) 할인 정책을 지원제도 주문 서비스를 변경하지않아도 된다.
1. 주문생성
2. 회원조회
3. 할인적용
4. 클라이언트 주문경과
 */
