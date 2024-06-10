package com.tsb.exception;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String entityName) {
        super("Ресурс " + entityName + " не найден");
    }
}
