package hello.springcore.member;

// 회원 서비스 구현체
public class MemberServiceImpl implements MemberService {
    // 회원 저장소 인터페이스를 구현한 구체적인 구현체를 사용
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    public MemberServiceImpl(MemoryMemberRepository memoryMemberRepository) {
    }

    // private final discountPolicy discountPolicy = new FixDiscountPolicy();
    // 회원 가입 기능
    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }
    // 회원 조회 기능
    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
