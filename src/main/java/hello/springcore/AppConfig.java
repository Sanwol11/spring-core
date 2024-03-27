package hello.springcore;

import hello.springcore.discount.DiscountPolicy;
import hello.springcore.discount.FixDiscountPolicy;
import hello.springcore.member.MemberRepository;
import hello.springcore.member.MemberService;
import hello.springcore.member.MemberServiceImpl;
import hello.springcore.member.MemoryMemberRepository;
import hello.springcore.order.OrderService;
import hello.springcore.order.OrderServiceImpl;
public class AppConfig {
    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
    }
    public OrderService orderService(){
            return new OrderServiceImpl(
                    new MemoryMemberRepository(),
                        discountPolicy());
                    //new FixDiscountPolicy());

    }
    public MemberRepository memberRepository(){

        return new MemoryMemberRepository();
    }
    public DiscountPolicy discountPolicy(){
        //return new RateDiscountPolicy();
        return new FixDiscountPolicy(); //할인정책을 변경
    }
}
/*
애플리케이션의 전체 동작 방식을 구성(Config)하기 위해,
구현 객체를 생성하고, 연결하는 책임을 가지는 별도의 설정 클래스를 만들자.
AppConfig는 생성한 객체 인스텀의 참조(레프런스)를 생성자를 통해서 주입(연결)해준다.
MemberServiceImpl 은 이제부터 의존관계에 대한 고민을 외부(AConfig)에 맡기고 실행에만 집중하면된다.
appConfig 객체는 memoryMemberRepositiry 객체를 생성하고 그 참조값은 memberServicImpl를 생성자로 전달한다.
APPConfig를 보면 역할(인터페이스)과 구현 클래스가 한눈에 들러온다. 그래서 앱 전체구성이 어떻게 되있는지 빠르게 파악할 수있다.

 */
