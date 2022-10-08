package com.example.feed.domain.feed.domain;

import com.example.feed.domain.board.domain.Board;
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
public class Feed extends BaseTimeEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(length = 20, nullable = false)
    private String title;

    @Column(length = 1000, nullable = false)
    private String content;

    @Column(nullable = false)
    private Integer likeCounts;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id", nullable = false)
    private Board board;

    @Builder
    public Feed(String title, String content, User user, Integer likeCounts, Board board) {
        this.title = title;
        this.content = content;
        this.user = user;
        this.likeCounts = likeCounts;
        this.board = board;
    }
}
