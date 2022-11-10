package com.lerkin.qa.api.exception;

public class EntryHasAddedException extends RuntimeException{

    public EntryHasAddedException() {
        super();
    }

    public EntryHasAddedException(String message) {
        super(message);
    }

    public EntryHasAddedException(String message, Throwable cause) {
        super(message, cause);
    }

    public EntryHasAddedException(Throwable cause) {
        super(cause);
    }
}
