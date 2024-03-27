package hello.springcore;

import hello.springcore.member.Grade;
import hello.springcore.member.Member;
import hello.springcore.member.MemberService;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
//      AppConfig appConfig = new AppConfig();
//      MemberService memberService = appConfig.memberService();
        // 스프링 컨테이너.md 적용.
        ApplicationContext ac = new AnnotationConfigReactiveWebApplicationContext(AppConfig.class);
        MemberService memberService = ac.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "maberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = "+ member.getName());
        System.out.println("find member = "+ findMember.getName());
    }
}
