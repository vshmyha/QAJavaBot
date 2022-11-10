package com.lerkin.qa.api.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "user_topics")
public class UserTopicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "chat_id")
    private long chatId;
    @ManyToOne()
    @JoinColumn(name = "topic_id")
    private TopicEntity topic;

    public UserTopicEntity(long chatId, TopicEntity topic) {
        this.chatId = chatId;
        this.topic = topic;
    }

    public UserTopicEntity(int id, long chatId, TopicEntity topic) {
        this.id = id;
        this.chatId = chatId;
        this.topic = topic;
    }
}
