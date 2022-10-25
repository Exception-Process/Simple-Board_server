package com.example.feed.domain.comment.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

<<<<<<< Updated upstream
=======
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

>>>>>>> Stashed changes
@Getter
@NoArgsConstructor
public class UpdateCommentRequest {

<<<<<<< Updated upstream
=======
    @NotBlank
    @Size(min = 1, max = 300, message = "댓글은 1~300자 사이여야되고, NULL이나 공백을 포함할 수 없습니다.")
>>>>>>> Stashed changes
    private String comment;
}
