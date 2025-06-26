package com.felipepinha.forumhub.controllers;

import com.felipepinha.forumhub.dto.topic.TopicCreationDTO;
import com.felipepinha.forumhub.dto.topic.TopicDTO;
import com.felipepinha.forumhub.dto.topic.TopicUpdateDTO;
import com.felipepinha.forumhub.repositories.TopicRepository;
import com.felipepinha.forumhub.services.TopicService;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topics")
public class TopicController {

    @Autowired
    TopicService topicService;

    @Autowired
    private TopicRepository topicRepository;

    @GetMapping
    public ResponseEntity<Page<TopicDTO>> listTopics(@PageableDefault(sort = "title", size = 10) Pageable pagination) {
        var page = topicRepository.findAllByActiveTrue(pagination).map(TopicDTO::new);

        return ResponseEntity.ok(page);
    }

    @GetMapping("/{topicId}")
    public ResponseEntity listSingleTopic(@PathVariable Long topicId) {
        var topic = topicRepository.findById(topicId).orElseThrow(() -> new ValidationException("Topic not found"));

        return ResponseEntity.ok(new TopicDTO(topic));
    }

    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody @Valid TopicCreationDTO data, UriComponentsBuilder uriBuilder) {
        var topic = topicService.createTopic(data);
        var uri = uriBuilder.path("/topics").buildAndExpand(topic.id()).toUri();

        return ResponseEntity.created(uri).body(topic);
    }

    @PutMapping("/{topicId}")
    @Transactional
    public ResponseEntity updateTopic(@PathVariable Long topicId, @RequestBody @Valid TopicUpdateDTO data) {
        var topic = topicService.updateTopic(topicId, data);

        return ResponseEntity.ok(topic);
    }

    @DeleteMapping("/{topicId}")
    @Transactional
    public ResponseEntity deleteTopic(@PathVariable Long topicId) {
        topicRepository.deleteById(topicId);

        return ResponseEntity.noContent().build();
    }
}
