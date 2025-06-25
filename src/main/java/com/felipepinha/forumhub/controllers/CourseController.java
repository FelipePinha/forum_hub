package com.felipepinha.forumhub.controllers;

import com.felipepinha.forumhub.dto.course.CourseWithTopicsDTO;
import com.felipepinha.forumhub.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("/{courseId}")
    public CourseWithTopicsDTO listCourseWithTopics(@PathVariable Long courseId) {
        var course = courseRepository.findCourseWithTopics(courseId).get();
        return new CourseWithTopicsDTO(course);
    }
}
