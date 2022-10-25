package com.example.feed.domain.feed.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class SearchFeedRequest {

    @NotBlank(message = "널이나 공백 포함 불가")
    private String titleSearch;
}
