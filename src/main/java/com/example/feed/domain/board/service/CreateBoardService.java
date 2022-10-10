package com.example.feed.domain.board.service;

import com.example.feed.domain.board.controller.dto.request.CreateBoardRequest;
import com.example.feed.domain.board.domain.Board;
import com.example.feed.domain.board.domain.repository.BoardRepository;
import com.example.feed.domain.user.domain.User;
import com.example.feed.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreateBoardService {

    private final UserFacade userFacade;
    private final BoardRepository boardRepository;

    public void execute(CreateBoardRequest request) {

        User user = userFacade.getUser();

        boardRepository.save(Board.builder()
                .title(request.getTitle())
                .introduction(request.getIntroduction())
                .admin(user)
                .build()
        );
    }
}
