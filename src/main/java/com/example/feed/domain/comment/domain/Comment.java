package com.example.feed.domain.comment.domain;

import com.example.feed.domain.feed.domain.Feed;
import com.example.feed.domain.user.domain.User;
import com.example.feed.global.entity.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Comment extends BaseTimeEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "feed_id", nullable = false)
    private Feed feed;

    @Column(length = 300, nullable = false)
    private String comment;

    @Builder
    public Comment(User user, Feed feed, String comment) {
        this.user = user;
        this.feed = feed;
        this.comment = comment;
    }
}
