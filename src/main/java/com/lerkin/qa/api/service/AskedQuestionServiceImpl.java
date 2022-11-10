package com.lerkin.qa.api.service;

import com.lerkin.qa.api.entity.AskedQuestionEntity;
import com.lerkin.qa.api.repository.AskedQuestionRepository;
import com.lerkin.qa.api.repository.ExerciseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class AskedQuestionServiceImpl implements AskedQuestionService {

    private final AskedQuestionRepository repository;
    private final ExerciseRepository exerciseRepository;

    @Override
    public List<Integer> getAskedExercisesByChatId(long chatId) {

        List<Integer> askedExercisesId = new ArrayList<>();
        List<AskedQuestionEntity> entities = repository.findByChatId(chatId);
        if (!entities.isEmpty()) {
            for (AskedQuestionEntity entity : entities) {
                askedExercisesId.add(entity.getExercise().getId());
            }
        }
        return askedExercisesId;
    }
}
