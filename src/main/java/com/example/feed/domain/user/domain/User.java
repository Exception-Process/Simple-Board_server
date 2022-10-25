package com.example.feed.domain.user.domain;

import com.example.feed.infrastructure.image.DefaultImage;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(length = 10, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(length = 10, nullable = false)
    private String name;

    @ColumnDefault(DefaultImage.USER_PROFILE_IMAGE)
    @Column(nullable = false)
    private String userProfileImage;

    @Builder
    public User(String email, String password, String name, String userProfileImage) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.userProfileImage = userProfileImage;
    }

    public void updateUser(String email, String name, String userProfileImage) {
        this.email = email;
        this.name = name;
        this.userProfileImage = userProfileImage;
    }
}
