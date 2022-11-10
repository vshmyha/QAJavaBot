package com.lerkin.qa.api.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "shedule_time")
public class ScheduleTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "chat_id")
    private long chatId;
    private Time time;

    public ScheduleTimeEntity(long chatId, Time time) {
        this.chatId = chatId;
        this.time = time;
    }

    public ScheduleTimeEntity(int id, long chatId, Time time) {
        this.id = id;
        this.chatId = chatId;
        this.time = time;


    }
}
