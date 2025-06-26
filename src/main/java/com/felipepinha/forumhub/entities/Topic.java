package com.felipepinha.forumhub.entities;

import com.felipepinha.forumhub.dto.topic.TopicCreationDTO;
import com.felipepinha.forumhub.dto.topic.TopicUpdateDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "topics")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String title;

    @Column(unique = true)
    private String message;

    private LocalDateTime createdAt;
    private boolean active;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL)
    private List<Answer> answers;

    public void updateInfo(TopicUpdateDTO topic) {
        this.title = topic.title();
        this.message = topic.message();
    }
}
