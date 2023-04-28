package com.example.feed.domain.member.domain.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class MemberRepository {

    private final MemberJpaRepository memberJpaRepository;
}
