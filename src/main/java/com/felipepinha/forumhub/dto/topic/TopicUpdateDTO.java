package com.felipepinha.forumhub.dto.topic;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TopicUpdateDTO(
        @NotBlank
        @NotNull
        String title,

        @NotBlank
        @NotNull
        String message
) {

}
