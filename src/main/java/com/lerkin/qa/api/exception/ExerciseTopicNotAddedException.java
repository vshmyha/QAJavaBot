package com.lerkin.qa.api.exception;

public class ExerciseTopicNotAddedException extends RuntimeException {

    public ExerciseTopicNotAddedException() {
    }

    public ExerciseTopicNotAddedException(String message) {
        super(message);
    }

    public ExerciseTopicNotAddedException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExerciseTopicNotAddedException(Throwable cause) {
        super(cause);
    }
}
