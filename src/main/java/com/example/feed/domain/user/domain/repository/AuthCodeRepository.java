package com.example.feed.domain.user.domain.repository;

import com.example.feed.domain.user.domain.AuthCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthCodeRepository extends JpaRepository<AuthCode, String> {
}
