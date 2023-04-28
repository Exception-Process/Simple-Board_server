package com.example.feed.domain.like.domain.repository;

import com.example.feed.domain.feed.domain.Feed;
import com.example.feed.domain.like.domain.Likes;
import com.example.feed.domain.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LikeRepository extends JpaRepository<Likes, Long> {

    boolean existsByMemberAndFeed(Member member, Feed feed);
    Optional<Likes> findByMemberAndFeed(Member member, Feed feed);
    List<Likes> findAllByMember(Member member);
}
