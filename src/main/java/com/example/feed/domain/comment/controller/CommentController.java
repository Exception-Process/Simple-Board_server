package com.example.feed.domain.comment.controller;

import com.example.feed.domain.comment.controller.dto.request.CreateCommentRequest;
import com.example.feed.domain.comment.controller.dto.request.UpdateCommentRequest;
import com.example.feed.domain.comment.controller.dto.response.CommentListResponse;
import com.example.feed.domain.comment.service.CreateCommentService;
import com.example.feed.domain.comment.service.DeleteCommentService;
import com.example.feed.domain.comment.service.QueryCommentListService;
import com.example.feed.domain.comment.service.UpdateCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/comment")
@RestController
public class CommentController {

    private final CreateCommentService createCommentService;
    private final DeleteCommentService deleteCommentService;
    private final QueryCommentListService queryCommentListService;
    private final UpdateCommentService updateCommentService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{feed-id}")
    public void create(@RequestBody @Valid CreateCommentRequest request, @PathVariable("feed-id") Long feedId) {
        createCommentService.execute(request, feedId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{comment-id}")
    public void delete(@PathVariable("comment-id") Long commentId) {
        deleteCommentService.execute(commentId);
    }

    @GetMapping("/{feed-id}")
    public CommentListResponse list(@PathVariable("feed-id") Long feedId) {
        return queryCommentListService.execute(feedId);
    }

    @PatchMapping("/{comment-id}")
    public void update(@PathVariable("comment-id") Long commentId, @RequestBody @Valid UpdateCommentRequest request) {
        updateCommentService.execute(commentId, request);
    }
}
