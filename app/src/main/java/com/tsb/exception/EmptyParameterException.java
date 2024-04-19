package com.tsb.exception;

public class EmptyParameterException extends BadRequestException {
    public EmptyParameterException(String parameterName) {
        super("Не задан параметр " + parameterName);
    }

}
