package com.tsb.exception;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
    public BadRequestException(String parameterName, String parameterValue, String constraint) {
        super("Некорректный параметр " + parameterName + ": " + parameterValue + ". " + constraint);
    }
}
