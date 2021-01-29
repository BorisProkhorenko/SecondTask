package com.epam.task.second.logic;

public class StringLogicException extends Throwable {
    public StringLogicException(String message, Throwable cause) {
        super(message, cause);
    }

    public StringLogicException(String message) {
        super(message);
    }
}
