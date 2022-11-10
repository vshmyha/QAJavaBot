package com.lerkin.qa.api.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "exercises")
public class ExerciseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "topic_id")
    private TopicEntity topic;
    @Column(name = "question")
    private String question;
    @Column(name = "answer")
    private String answer;
    @OneToMany(mappedBy = "exercise", fetch = FetchType.LAZY)
    private List<AskedQuestionEntity> askedQuestions;

    public ExerciseEntity(TopicEntity topic, String question, String answer) {
        this.topic = topic;
        this.question = question;
        this.answer = answer;
    }
}
