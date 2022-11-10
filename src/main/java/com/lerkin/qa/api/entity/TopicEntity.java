package com.lerkin.qa.api.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "topics")
public class TopicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(mappedBy = "topic")
    private List<ExerciseEntity> exercises;
    @OneToMany(mappedBy = "topic")
    private List<UserTopicEntity> userTopics;
    @OneToMany(mappedBy = "topic")
    private List<AskedQuestionEntity> askedQuestions;

}
