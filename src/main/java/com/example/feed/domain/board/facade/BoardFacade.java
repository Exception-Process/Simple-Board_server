package com.example.feed.domain.board.facade;

import com.example.feed.domain.board.domain.Board;
import com.example.feed.domain.board.domain.repository.BoardRepository;
import com.example.feed.domain.board.exception.BoardNotFoundException;
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
}
