package com.lerkin.qa.api.dto;

import com.lerkin.qa.api.entity.ExerciseEntity;
import com.lerkin.qa.api.entity.ScheduleTimeEntity;
import com.lerkin.qa.api.entity.TopicEntity;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class DtoMapper {

    public static List<TopicDto> convertTopicDto(List<TopicEntity> entities) {

        List<TopicDto> dtos = new ArrayList<>();
        for (TopicEntity entity : entities) {
            TopicDto dto = new TopicDto(entity.getId(), entity.getName());
            dtos.add(dto);
        }
        return dtos;
    }

    public static List<ExerciseDto> convertExerciseDtoQuestion(List<ExerciseEntity> entities, Integer topicId) {

        List<ExerciseDto> dtos = new ArrayList<>();
        for (ExerciseEntity entity : entities) {
            ExerciseDto dto = new ExerciseDto(entity.getId(), topicId, entity.getQuestion(), null);
            dtos.add(dto);
        }
        return dtos;
    }

    public static List<ExerciseDto> convertExerciseDto(List<ExerciseEntity> entities, Integer topicId) {

        List<ExerciseDto> dtos = new ArrayList<>();
        for (ExerciseEntity entity : entities) {
            ExerciseDto dto = new ExerciseDto(entity.getId(), topicId, entity.getQuestion(), entity.getAnswer());
            dtos.add(dto);
        }
        return dtos;
    }

    public static ExerciseDto convertExerciseDto(ExerciseEntity exercise) {

        return new ExerciseDto(exercise.getId(), exercise.getTopic().getId(), exercise.getQuestion(), exercise.getAnswer());
    }

    public static ScheduleTimeEntity convertScheduleTimeEntity(ScheduleTimeDto scheduleTimeDto) {

        if (scheduleTimeDto.getId() != 0) {
            return new ScheduleTimeEntity(scheduleTimeDto.getId(), scheduleTimeDto.getChatId(), scheduleTimeDto.getTime());
        }
        return new ScheduleTimeEntity(scheduleTimeDto.getChatId(), scheduleTimeDto.getTime());
    }

    public static ScheduleTimeDto convertScheduleTimeDto(ScheduleTimeEntity scheduleTimeEntity) {

        return new ScheduleTimeDto(scheduleTimeEntity.getId(), scheduleTimeEntity.getChatId(), scheduleTimeEntity.getTime());
    }
}
