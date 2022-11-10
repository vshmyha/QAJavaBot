package com.lerkin.qa.api.controller;

import com.lerkin.qa.api.dto.ExerciseDto;
import com.lerkin.qa.api.service.AskedQuestionService;
import com.lerkin.qa.api.service.ExerciseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(Navigation.EXERCISE)
public class ExerciseController {

    private final ExerciseService exerciseService;
    private final AskedQuestionService askedQuestionService;

    @GetMapping(Navigation.BY_TOPIC_ID)
    public ResponseEntity<?> getFullExercisesByTopicId(@PathVariable(Navigation.TOPIC_ID) Integer topicId) {

        List<ExerciseDto> exercises = exerciseService.getAllByTopicId(topicId);
        return ResponseEntity.ok(exercises);
    }

    @PutMapping(Navigation.QUESTION_ASK_BY_CHAT_ID)
    public ResponseEntity<?> askQuestion(@PathVariable(Navigation.CHAT_ID) long chatId) {

        List<Integer> askedExercisesId = askedQuestionService.getAskedExercisesByChatId(chatId);
        ExerciseDto exercise = exerciseService.getNotAskedExercise(chatId, askedExercisesId);
        return ResponseEntity.ok(exercise);
    }

    @GetMapping(Navigation.BY_ID)
    public ResponseEntity<?> getById(@PathVariable(Navigation.ID) Integer id) {

        ExerciseDto exercise = exerciseService.getById(id);
        return ResponseEntity.ok(exercise);
    }

    @GetMapping(Navigation.STATISTIC_BY_CHAT_ID)
    public ResponseEntity<?> statistic(@PathVariable(Navigation.CHAT_ID) long chatId) {

        HashMap<String, String> statistic = exerciseService.getStatistic(chatId);
        return ResponseEntity.ok(statistic);
    }
}