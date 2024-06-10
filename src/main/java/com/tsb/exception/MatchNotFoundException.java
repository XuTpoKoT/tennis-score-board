package com.tsb.exception;

public class MatchNotFoundException extends RuntimeException {
    public MatchNotFoundException(String message) {
        super(message);
    }
    public MatchNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public MatchNotFoundException(Throwable cause) {
        super(cause);
    }
}
