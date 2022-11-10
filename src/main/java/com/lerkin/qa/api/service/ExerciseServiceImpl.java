package com.lerkin.qa.api.service;

import com.lerkin.qa.api.dto.DtoMapper;
import com.lerkin.qa.api.dto.ExerciseDto;
import com.lerkin.qa.api.entity.AskedQuestionEntity;
import com.lerkin.qa.api.entity.ExerciseEntity;
import com.lerkin.qa.api.entity.TopicEntity;
import com.lerkin.qa.api.entity.UserTopicEntity;
import com.lerkin.qa.api.exception.ExerciseOverException;
import com.lerkin.qa.api.exception.ExerciseTopicNotAddedException;
import com.lerkin.qa.api.repository.AskedQuestionRepository;
import com.lerkin.qa.api.repository.ExerciseRepository;
import com.lerkin.qa.api.repository.TopicRepository;
import com.lerkin.qa.api.repository.UserTopicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ExerciseServiceImpl implements ExerciseService {

    private final ExerciseRepository exerciseRepository;
    private final TopicRepository topicRepository;

    private final UserTopicRepository userTopicRepository;
    private final AskedQuestionRepository askedQuestionRepository;

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

    @Override
    public List<ExerciseDto> getAllByTopicId(Integer topicId) {

        List<ExerciseEntity> entities = exerciseRepository.findAllByTopic_id(topicId);
        return DtoMapper.convertExerciseDto(entities, topicId);
    }

    @Override
    public ExerciseDto getNotAskedExercise(long chatId, List<Integer> askedExercisesId) {

        ExerciseEntity exercise;
        if (askedExercisesId.isEmpty()) {
            exercise = exerciseRepository.findFirstNotAsked(chatId);
            if (Objects.nonNull(exercise)) {
                AskedQuestionEntity questionEntity = new AskedQuestionEntity(chatId, exercise, exercise.getTopic());
                askedQuestionRepository.save(questionEntity);
            } else {
                throw new ExerciseTopicNotAddedException("You have not added topic yet.");
            }
        } else {
            exercise = exerciseRepository.findNotAsked(chatId, askedExercisesId);
            if (Objects.isNull(exercise)) {
                throw new ExerciseOverException("The last question was asked.");
            } else {
                AskedQuestionEntity questionEntity = new AskedQuestionEntity(chatId, exercise, exercise.getTopic());
                askedQuestionRepository.save(questionEntity);
            }
        }
        return DtoMapper.convertExerciseDto(exercise);
    }

    @Override
    public ExerciseDto getById(Integer id) {

        ExerciseEntity exercise = exerciseRepository.findById(id).orElseThrow(() -> new RuntimeException());
        return DtoMapper.convertExerciseDto(exercise);
    }

    @Override
    public HashMap<String, String> getStatistic(long chatId) {

        HashMap<String, String> statistic = new HashMap<>();
        List<UserTopicEntity> userTopics = userTopicRepository.findByChatId(chatId);
        userTopics.forEach(topic -> {
            int topicId = topic.getTopic().getId();
            int allExerciseCount = exerciseRepository.countByTopicId(topicId);
            int askedExerciseCount = askedQuestionRepository.countByChatIdAndTopicId(chatId, topicId);
            String count = askedExerciseCount + "/" + allExerciseCount;
            statistic.put(topic.getTopic().getName(), count);
        });
        return statistic;
    }

}
