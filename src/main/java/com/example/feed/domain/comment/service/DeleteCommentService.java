package com.example.feed.domain.comment.service;

import com.example.feed.domain.comment.domain.Comment;
import com.example.feed.domain.comment.domain.repository.CommentRepository;
import com.example.feed.domain.comment.facade.CommentFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DeleteCommentService {

    private final CommentFacade commentFacade;
    private final CommentRepository commentRepository;

    public void execute(Long commentId) {
<<<<<<< Updated upstream
        Comment comment = commentFacade.getComment(id);
=======
        Comment comment = commentFacade.getComment(commentId);
>>>>>>> Stashed changes
        commentRepository.delete(comment);
    }
}
