package com.example.feed.domain.user.facade;

import com.example.feed.domain.user.domain.User;
import com.example.feed.domain.user.domain.repository.UserRepository;
import com.example.feed.domain.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserFacade {

    private final UserRepository userRepository;

    public boolean emailIsExist(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    public User getUser() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByEmail(email)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }
}
