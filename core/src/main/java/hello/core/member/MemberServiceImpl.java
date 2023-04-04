package hello.core.member;

public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository; // 추상화에만 의존

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository; //생성자를 통해서 구현체에 무엇이 들어갈지 결정됨
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
