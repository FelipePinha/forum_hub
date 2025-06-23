package com.felipepinha.forumhub.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "answers")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    private Topic topic;

    private String message;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String solution;
}
