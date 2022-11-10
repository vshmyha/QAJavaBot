package com.lerkin.qa.api.dto;

import lombok.Value;

import java.sql.Time;

@Value
public class ScheduleTimeDto {

    int id;
    long chatId;
    Time time;
}
