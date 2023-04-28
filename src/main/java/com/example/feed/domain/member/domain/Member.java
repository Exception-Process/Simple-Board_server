package com.example.feed.domain.member.domain;

import com.example.feed.domain.board.domain.Board;
import com.example.feed.domain.member.domain.types.Authority;
import com.example.feed.domain.user.domain.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


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

    @Column(columnDefinition = "VARCHAR(20)", nullable = false)
    private String name;

    @Column(columnDefinition = "VARCHAR(5)", nullable = false)
    private Authority authority;

    @Column(columnDefinition = "VARCHAR(400)", nullable = false)
    private String memberProfileImage;

    @Column(columnDefinition = "TINYINT(1)", nullable = false)
    private boolean approved;

    @Builder
    public Member(User user, Board board, String name, Authority authority, String memberProfileImage, boolean approved) {
        this.user = user;
        this.board = board;
        this.name = name;
        this.authority = authority;
        this.memberProfileImage = memberProfileImage;
        this.approved = approved;
    }

    public void permitJoin() {
        this.approved = true;
    }

    public void update(String name, String memberProfileImage) {
        this.name = name;
        this.memberProfileImage = memberProfileImage;
    }
}
