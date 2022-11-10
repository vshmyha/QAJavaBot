package com.lerkin.qa.api.service;

import com.lerkin.qa.api.dto.ExerciseDto;

import java.util.HashMap;
import java.util.List;

public interface ExerciseService {

    void saveEntity(List<ExerciseDto> entities);

    List<ExerciseDto> getAllByTopicId(Integer topicId);

    ExerciseDto getNotAskedExercise(long chatId, List<Integer> askedExercisesId);

    ExerciseDto getById(Integer id);

    HashMap<String, String> getStatistic(long chatId);
}
