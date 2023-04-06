package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig { //어떻게 구현할 것인지.

    //@Bean memberService -> new MemoryMemberRepository()
    //@Bean orderService -> new MemoryMemberRepository()
    //로 두번 호출이 된다 -> 각각 다른 2개의 memoryMemberRepository가 생성되는 것처럼 보인다. 그러나 싱글톤이 깨지는것은 아님

    // 아래의 메서드 호출 순서를 생각해보자면

    // call AppConfig.memberService
    // call AppConfig.memberRepository

    // call AppConfig.memberRepository

    //call AppConfig.orderService
    //call AppConfig.memberRepository

    //memberRepository는 3번 호출되어야한다
    //그러나 실제로 호출해보면 1번만 호출된다!!!


    @Bean
    public MemberService memberService(){
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository()); //구현체 -> memory를 사용하겠다.
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), new FixDiscountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }


}
