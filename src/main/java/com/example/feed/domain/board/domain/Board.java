package com.example.feed.domain.board.domain;

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
public class Board extends BaseTimeEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false, length = 20)
    private String title;

    @Column(nullable = false, length = 100)
    private String introduction;

    @Column(nullable = false)
    private Integer boardMemberCounts;

    @Column(nullable = false)
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
