package com.example.feed.domain.user.facade;

import com.example.feed.domain.user.domain.User;
import com.example.feed.domain.user.domain.repository.UserJpaRepository;
import com.example.feed.domain.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserFacade {

    private final UserJpaRepository userJpaRepository;

    public boolean emailIsExist(String email) {
        return userJpaRepository.findByEmail(email).isPresent();
    }

    public User getUser() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return getUserByEmail(email);
    }

    public User getUserByEmail(String email) {
        return userJpaRepository.findByEmail(email)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }
}
