package com.felipepinha.forumhub.repositories;

import com.felipepinha.forumhub.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query("SELECT c FROM Course c LEFT JOIN FETCH c.topics WHERE c.id = :courseId")
    Optional<Course> findCourseWithTopics(@Param("courseId") Long courseId);
}
