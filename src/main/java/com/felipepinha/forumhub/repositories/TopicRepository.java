package com.felipepinha.forumhub.repositories;

import com.felipepinha.forumhub.entities.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Long> {
}
