package com.example.feed.domain.comment.domain.repository;

import com.example.feed.domain.comment.domain.Comment;
import com.example.feed.domain.feed.domain.Feed;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findAllByFeedOrderByCreatedAtDesc(Feed feed);
}
