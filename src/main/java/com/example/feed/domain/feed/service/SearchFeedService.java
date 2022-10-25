package com.example.feed.domain.feed.service;

import com.example.feed.domain.board.controller.dto.request.SearchBoardRequest;
import com.example.feed.domain.board.domain.Board;
import com.example.feed.domain.board.facade.BoardFacade;
import com.example.feed.domain.feed.controller.dto.request.SearchFeedRequest;
import com.example.feed.domain.feed.controller.dto.response.FeedElement;
import com.example.feed.domain.feed.controller.dto.response.FeedListResponse;
import com.example.feed.domain.feed.domain.Feed;
import com.example.feed.domain.feed.domain.repository.FeedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class SearchFeedService {

    private final FeedRepository feedRepository;
    private final BoardFacade boardFacade;

    public FeedListResponse execute(Long boardId, SearchFeedRequest request) {

        Board board = boardFacade.getBoardById(boardId);

        List<FeedElement> feedList = feedRepository.findAllByBoardAndTitleContaining(board, request.getTitleSearch())
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
