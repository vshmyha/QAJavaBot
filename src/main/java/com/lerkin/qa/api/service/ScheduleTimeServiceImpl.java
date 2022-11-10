package com.lerkin.qa.api.service;

import com.lerkin.qa.api.dto.DtoMapper;
import com.lerkin.qa.api.dto.ScheduleTimeDto;
import com.lerkin.qa.api.entity.ScheduleTimeEntity;
import com.lerkin.qa.api.repository.ScheduleTimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.Objects;

@RequiredArgsConstructor
@Service
public class ScheduleTimeServiceImpl implements ScheduleTimeService {

    private final ScheduleTimeRepository scheduleTimeRepository;

    @Override
    public void saveScheduleTime(ScheduleTimeDto scheduleTime) {

        ScheduleTimeEntity scheduleTimeEntity = scheduleTimeRepository.findByChatId(scheduleTime.getChatId());
        if (Objects.nonNull(scheduleTimeEntity)) {
            ScheduleTimeDto dto = new ScheduleTimeDto(scheduleTimeEntity.getId(), scheduleTimeEntity.getChatId(), scheduleTime.getTime());
            scheduleTimeRepository.save(DtoMapper.convertScheduleTimeEntity(dto));
        } else {
            defaultSave(scheduleTime.getChatId());
        }
    }

    private void defaultSave(long chatId) {

        ScheduleTimeDto scheduleTimeDto = new ScheduleTimeDto(0, chatId, Time.valueOf("00:00:00"));
        scheduleTimeRepository.save(DtoMapper.convertScheduleTimeEntity(scheduleTimeDto));
    }

    @Override
    public ScheduleTimeDto getScheduleTime(long chatId) {

        ScheduleTimeEntity scheduleTimeEntity = scheduleTimeRepository.findByChatId(chatId);
        if (Objects.isNull(scheduleTimeEntity)) {
            defaultSave(chatId);
        }
        return DtoMapper.convertScheduleTimeDto(scheduleTimeRepository.findByChatId(chatId));
    }
}
