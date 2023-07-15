package com.danla2402.hellospring;

import com.danla2402.hellospring.repository.MemberRepository;
import com.danla2402.hellospring.repository.MemoryMemberRepository;
import com.danla2402.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
