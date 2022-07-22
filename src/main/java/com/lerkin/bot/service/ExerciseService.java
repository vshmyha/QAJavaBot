package com.lerkin.bot.service;

import com.lerkin.bot.dto.ExerciseDto;
import com.lerkin.bot.entity.ExerciseEntity;

import java.util.List;

public interface ExerciseService {

    void saveEntity(List<ExerciseDto> entities);
}
