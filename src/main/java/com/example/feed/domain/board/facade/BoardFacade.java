package com.example.feed.domain.board.facade;

import com.example.feed.domain.board.domain.Board;
import com.example.feed.domain.board.domain.repository.BoardJpaRepository;
import com.example.feed.domain.board.exception.BadAdminException;
import com.example.feed.domain.board.exception.BoardNotFoundException;
import com.example.feed.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class BoardFacade {

    private final BoardJpaRepository boardJpaRepository;

    public Board getBoardById(Long id) {
        return boardJpaRepository.findById(id)
                .orElseThrow(() -> BoardNotFoundException.EXCEPTION);
    }

    public Board getBoardByAdmin(User admin) {
        return boardJpaRepository.findByAdmin(admin)
                .orElseThrow(() -> BadAdminException.EXCEPTION);
    }

}
