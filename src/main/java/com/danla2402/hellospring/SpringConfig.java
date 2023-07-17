package com.danla2402.hellospring;

import com.danla2402.hellospring.repository.JdbcMemberRepository;
import com.danla2402.hellospring.repository.JdbcTemplateMemberRepository;
import com.danla2402.hellospring.repository.MemberRepository;
import com.danla2402.hellospring.repository.MemoryMemberRepository;
import com.danla2402.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    private DataSource dataSource;

    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
        return new JdbcTemplateMemberRepository(dataSource);
    }
}
