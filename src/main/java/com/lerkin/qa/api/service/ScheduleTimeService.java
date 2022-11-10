package com.lerkin.qa.api.service;

import com.lerkin.qa.api.dto.ScheduleTimeDto;

public interface ScheduleTimeService {

    void saveScheduleTime(ScheduleTimeDto scheduleTime);

    ScheduleTimeDto getScheduleTime(long chatId);
}
