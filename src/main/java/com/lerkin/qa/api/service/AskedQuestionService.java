package com.lerkin.qa.api.service;

import com.lerkin.qa.api.dto.ExerciseDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface AskedQuestionService {

    List<Integer> getAskedExercisesByChatId(long chatId);

}
