package com.felipepinha.forumhub.controllers;

import com.felipepinha.forumhub.dto.topic.TopicCreationDTO;
import com.felipepinha.forumhub.dto.topic.TopicDTO;
import com.felipepinha.forumhub.repositories.TopicRepository;
import com.felipepinha.forumhub.services.TopicService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topics")
public class TopicController {

    @Autowired
    TopicService topicService;

    @Autowired
    private TopicRepository topicRepository;

    @GetMapping
    public Page<TopicDTO> listTopics(@PageableDefault(sort = "title", size = 10) Pageable pagination) {
        return topicRepository.findAllByActiveTrue(pagination).map(TopicDTO::new);
    }

    @PostMapping
    @Transactional
    public TopicDTO create(@RequestBody @Valid TopicCreationDTO data) {
        return topicService.createTopic(data);
    }
}
