package com.example.feed.domain.user.domain.repository;

import com.example.feed.domain.auth.domain.AuthCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthCodeJpaRepository extends JpaRepository<AuthCode, String> {
}
