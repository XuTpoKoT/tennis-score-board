package com.tsb.exception;

public class MatchIsNotFinishedException extends RuntimeException {
    public MatchIsNotFinishedException(String message) {
        super(message);
    }
    public MatchIsNotFinishedException(String message, Throwable cause) {
        super(message, cause);
    }

    public MatchIsNotFinishedException(Throwable cause) {
        super(cause);
    }
}
