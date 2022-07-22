package com.lerkin.bot.service;

import com.lerkin.bot.dto.ExerciseDto;
import com.lerkin.bot.entity.ExerciseEntity;
import com.lerkin.bot.entity.TopicEntity;
import com.lerkin.bot.repository.ExerciseRepository;
import com.lerkin.bot.repository.TopicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExerciseServiceImpl implements ExerciseService {

    private final ExerciseRepository exerciseRepository;
    private final TopicRepository topicRepository;

    @Override
    public void saveEntity(List<ExerciseDto> exerciseDtos) {

        List<ExerciseEntity> entities = new ArrayList<>();
        for (ExerciseDto exerciseDto : exerciseDtos) {
            TopicEntity topicEntity = topicRepository.getReferenceById(exerciseDto.getTopicId());
            ExerciseEntity exerciseEntity = new ExerciseEntity(topicEntity, exerciseDto.getQuestion(), exerciseDto.getAnswer());
            entities.add(exerciseEntity);
        }
        exerciseRepository.saveAll(entities);
    }
}
