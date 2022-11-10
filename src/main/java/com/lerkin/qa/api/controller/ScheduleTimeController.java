package com.lerkin.qa.api.controller;

import com.lerkin.qa.api.dto.ScheduleTimeDto;
import com.lerkin.qa.api.service.ScheduleTimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(Navigation.SCHEDULE_TIME)
public class ScheduleTimeController {

    private final ScheduleTimeService scheduleTimeService;

    @PostMapping()
    public ResponseEntity<?> saveScheduleTimeSetting(@RequestBody ScheduleTimeDto scheduleTimeDto) {

       scheduleTimeService.saveScheduleTime(scheduleTimeDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping(Navigation.BY_CHAT_ID)
    public ResponseEntity<?> getScheduleTime(@PathVariable(Navigation.CHAT_ID) long chatId) {

        ScheduleTimeDto scheduleTime = scheduleTimeService.getScheduleTime(chatId);
        return ResponseEntity.ok(scheduleTime);
    }
}