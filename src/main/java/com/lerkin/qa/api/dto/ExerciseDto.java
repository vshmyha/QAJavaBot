package com.lerkin.qa.api.dto;

import lombok.Value;

@Value
public class ExerciseDto {

     int id;
     int topicId;
     String question;
     String answer;

}
