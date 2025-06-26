package com.felipepinha.forumhub.services;

import com.felipepinha.forumhub.dto.topic.TopicCreationDTO;
import com.felipepinha.forumhub.dto.topic.TopicDTO;
import com.felipepinha.forumhub.dto.topic.TopicUpdateDTO;
import com.felipepinha.forumhub.entities.Topic;
import com.felipepinha.forumhub.repositories.AuthRepository;
import com.felipepinha.forumhub.repositories.CourseRepository;
import com.felipepinha.forumhub.repositories.TopicRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private AuthRepository authRepository;

    @Autowired
    private CourseRepository courseRepository;

    public TopicDTO createTopic(TopicCreationDTO data) {
        var user = authRepository.findById(data.userId())
                .orElseThrow(() -> new ValidationException("User not found"));

        var course = courseRepository.findById(data.courseId())
                .orElseThrow(() -> new ValidationException("Course not found"));

        Topic topic = Topic.builder()
                .title(data.title())
                .message(data.message())
                .createdAt(LocalDateTime.now())
                .active(true)
                .user(user)
                .course(course)
                .build();

        topicRepository.save(topic);

        return new TopicDTO(topic);
    }

    public TopicDTO updateTopic(Long topicId, TopicUpdateDTO data) {
        Topic topic = topicRepository.findById(topicId)
                .orElseThrow(() -> new ValidationException("Topic not found"));

        topic.updateInfo(data);

        return new TopicDTO(topic);
    }
}
