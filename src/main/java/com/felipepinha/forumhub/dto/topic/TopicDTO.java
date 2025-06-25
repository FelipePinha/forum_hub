package com.felipepinha.forumhub.dto.topic;

import com.felipepinha.forumhub.entities.Topic;

import java.time.LocalDateTime;

public record TopicDTO(
        Long id,
        String title,
        String message,
        LocalDateTime createdAt
) {
    public TopicDTO(Topic topic) {
        this(topic.getId(), topic.getTitle(), topic.getMessage(), topic.getCreatedAt());
    }
}
