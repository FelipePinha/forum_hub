package com.felipepinha.forumhub.repositories;

import com.felipepinha.forumhub.entities.Topic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TopicRepository extends JpaRepository<Topic, Long> {
    Page<Topic> findAllByActiveTrue(Pageable pagination);
}
