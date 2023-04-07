package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository; // 추상화에만 의존

    @Autowired //MemberRepository에 맞는 (지금은 memoryMemberRepository)를 자동주입해준다.
               //ac.getBean()
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

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }


}
