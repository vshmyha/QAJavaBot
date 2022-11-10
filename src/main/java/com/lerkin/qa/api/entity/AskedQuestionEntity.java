package com.lerkin.qa.api.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Table(name = "asked_questions")
public class AskedQuestionEntity {

    @Id
    private int id;
    @Column(name = "chat_id")
    private long chatId;
    @ManyToOne
    @JoinColumn(name = "question_id")
    private ExerciseEntity exercise;
    @ManyToOne
    @JoinColumn(name = "topic_id")
    private TopicEntity topic;

    public AskedQuestionEntity(long chatId, ExerciseEntity exercise, TopicEntity topic) {
        this.chatId = chatId;
        this.exercise = exercise;
        this.topic = topic;
    }
}
