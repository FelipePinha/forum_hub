package com.felipepinha.forumhub.controllers;

import com.felipepinha.forumhub.dto.topic.TopicCreationDTO;
import com.felipepinha.forumhub.dto.topic.TopicDTO;
import com.felipepinha.forumhub.services.TopicService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topics")
public class TopicController {

    @Autowired
    TopicService topicService;

    @PostMapping
    @Transactional
    public TopicDTO create(@RequestBody @Valid TopicCreationDTO data) {
        return topicService.createTopic(data);
    }
}
