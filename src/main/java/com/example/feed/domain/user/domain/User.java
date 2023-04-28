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

    @Column(columnDefinition = "VARCHAR(30)", nullable = false)
    private String email;

    @Column(columnDefinition = "CHAR(60)",nullable = false)
    private String password;

    @Column(columnDefinition = "VARCHAR(10)", nullable = false)
    private String name;

    @Column(columnDefinition = "VARCHAR(200)")
    private String deviceToken;

    @ColumnDefault(DefaultImage.USER_PROFILE_IMAGE)
    @Column(columnDefinition = "VARCHAR(400)", nullable = false)
    private String userProfileImage;

    @Builder
    public User(String email, String password, String name, String deviceToken, String userProfileImage) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.deviceToken = deviceToken;
        this.userProfileImage = userProfileImage;
    }

    public void updateUser(String email, String name, String userProfileImage) {
        this.email = email;
        this.name = name;
        this.userProfileImage = userProfileImage;
    }
}
