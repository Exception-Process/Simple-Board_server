package com.example.feed.domain.like.controller;

import com.example.feed.domain.like.controller.dto.response.LikeResponse;
import com.example.feed.domain.like.service.AddLikeService;
import com.example.feed.domain.like.service.SubLikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/like")
@RestController
public class LikeController {

    private final AddLikeService addLikeService;
    private final SubLikeService subLikeService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{feed-id}")
    public LikeResponse addLike(@PathVariable("feed-id") Long feedId) {
        return addLikeService.execute(feedId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{feed-id}")
    public LikeResponse subLike(@PathVariable("feed-id") Long feedId) {
        return subLikeService.execute(feedId);
    }
}
