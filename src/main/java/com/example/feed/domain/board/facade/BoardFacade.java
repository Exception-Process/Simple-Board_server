package com.example.feed.domain.board.facade;

import com.example.feed.domain.board.domain.Board;
import com.example.feed.domain.board.domain.repository.BoardRepository;
import com.example.feed.domain.board.exception.BadAdminException;
import com.example.feed.domain.board.exception.BoardNotFoundException;
import com.example.feed.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class BoardFacade {

    private final BoardRepository boardRepository;

    public Board getBoardById(Long id) {
        return boardRepository.findById(id)
                .orElseThrow(() -> BoardNotFoundException.EXCEPTION);
    }

    public Board getBoardByAdmin(User admin) {
        return boardRepository.findByAdmin(admin)
                .orElseThrow(() -> BadAdminException.EXCEPTION);
    }

}
