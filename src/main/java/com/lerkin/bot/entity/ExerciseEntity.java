package com.lerkin.bot.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "exercises")
public class ExerciseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "id_topic")
    private TopicEntity topic;
    @Column(name = "question")
    private String question;
    @Column(name = "answer")
    private String answer;

    public ExerciseEntity(TopicEntity topic, String question, String answer) {
        this.topic = topic;
        this.question = question;
        this.answer = answer;
    }
}
