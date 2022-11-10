package com.lerkin.qa.api.exception;

public class ExerciseOverException extends RuntimeException {

    public ExerciseOverException() {
        super();
    }

    public ExerciseOverException(String message) {
        super(message);
    }

    public ExerciseOverException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExerciseOverException(Throwable cause) {
        super(cause);
    }
}
