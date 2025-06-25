package com.felipepinha.forumhub.dto.course;

import com.felipepinha.forumhub.dto.topic.TopicDTO;
import com.felipepinha.forumhub.entities.Course;
import com.felipepinha.forumhub.entities.Topic;

import java.util.List;

public record CourseWithTopicsDTO(
        String name,
        String Category,
        List<TopicDTO> topics
) {
    public CourseWithTopicsDTO(Course course) {
        this(course.getName(),
                course.getCategory(),
                course.getTopics().stream().map(TopicDTO::new).toList());
    }
}
