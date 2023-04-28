package com.example.feed.domain.feed.service;

import com.example.feed.domain.board.domain.Board;
import com.example.feed.domain.board.facade.BoardFacade;
import com.example.feed.domain.feed.controller.dto.response.FeedElement;
import com.example.feed.domain.feed.controller.dto.response.FeedListResponse;
import com.example.feed.domain.feed.domain.Feed;
import com.example.feed.domain.feed.domain.repository.FeedJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class QueryFeedListService {

    private final FeedJpaRepository feedJpaRepository;
    private final BoardFacade boardFacade;

    @Transactional(readOnly = true)
    public FeedListResponse execute(Long boardId) {

        Board board = boardFacade.getBoardById(boardId);

        List<FeedElement> feedList = feedJpaRepository.findAllByBoardOrderByCreatedAtDesc(board)
                .stream()
                .map(this::feedListBuild)
                .collect(Collectors.toList());

        return new FeedListResponse(feedList);
    }

    private FeedElement feedListBuild(Feed feed) {
        return FeedElement.builder()
                .feedId(feed.getId())
                .title(feed.getTitle())
                .memberName(feed.getMember().getName())
                .createdAt(feed.getCreatedAt())
                .build();
    }
}
