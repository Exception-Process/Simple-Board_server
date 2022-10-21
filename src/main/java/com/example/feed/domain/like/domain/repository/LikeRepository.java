package com.example.feed.domain.like.domain.repository;

import com.example.feed.domain.feed.domain.Feed;
import com.example.feed.domain.like.domain.Like;
import com.example.feed.domain.member.domain.Member;
import com.example.feed.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LikeRepository extends JpaRepository<Like, Long> {

    boolean existsByMemberAndFeed(Member member, Feed feed);
    Optional<Like> findByMemberAndFeed(Member member, Feed feed);
    List<Like> findAllByMember(Member member);
}
