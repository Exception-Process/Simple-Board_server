package com.example.feed.domain.member.domain;

import com.example.feed.domain.board.domain.Board;
import com.example.feed.domain.member.domain.types.Authority;
import com.example.feed.domain.user.domain.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Member {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id", nullable = false)
    private Board board;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false)
    private Authority authority;

    @Column(nullable = false)
    private String memberProfileImage;

    @Column(nullable = false)
    private boolean join;

    @Builder
    public Member(User user, Board board, String name, Authority authority, String memberProfileImage, boolean join) {
        this.user = user;
        this.board = board;
        this.name = name;
        this.authority = authority;
        this.memberProfileImage = memberProfileImage;
        this.join = join;
    }

    public void permitJoin() {
        this.join = true;
    }

    public void update(String name, String memberProfileImage) {
        this.name = name;
        this.memberProfileImage = memberProfileImage;
    }
}
