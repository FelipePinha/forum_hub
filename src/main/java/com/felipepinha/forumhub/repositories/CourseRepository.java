package com.felipepinha.forumhub.repositories;

import com.felipepinha.forumhub.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
