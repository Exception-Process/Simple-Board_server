package com.example.feed.domain.member.facade;

import com.example.feed.domain.member.domain.Member;
import com.example.feed.domain.member.domain.repository.MemberRepository;
import com.example.feed.domain.member.exception.MemberNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MemberFacade {

    private final MemberRepository memberRepository;

    public Member getMemberById(Long id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> MemberNotFoundException.EXCEPTION);
    }
}
