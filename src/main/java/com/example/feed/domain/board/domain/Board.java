package com.example.feed.domain.board.domain;

import com.example.feed.domain.user.domain.User;
import com.example.feed.global.entity.BaseTimeEntity;
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
public class Board extends BaseTimeEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(columnDefinition = "VARCHAR(20)", nullable = false)
    private String title;

    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String introduction;

    @Column(columnDefinition = "INT", nullable = false)
    private Integer boardMemberCounts;

    @Column(columnDefinition = "VARCHAR(400)", nullable = false)
    private String boardProfileImage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_id", nullable = false, unique = true)
    private User admin;

    @Builder
    public Board(String title, String introduction, Integer boardMemberCounts, String boardProfileImage, User admin) {
        this.title = title;
        this.introduction = introduction;
        this.boardMemberCounts = boardMemberCounts;
        this.boardProfileImage = boardProfileImage;
        this.admin = admin;
    }

    public void update(String introduction, String boardProfileImage) {
        this.introduction = introduction;
        this.boardProfileImage = boardProfileImage;

    }

    public void addBoardMemberCounts() {
        this.boardMemberCounts += 1;
    }

    public void subBoardMemberCounts() {
        this.boardMemberCounts -= 1;
    }
}
