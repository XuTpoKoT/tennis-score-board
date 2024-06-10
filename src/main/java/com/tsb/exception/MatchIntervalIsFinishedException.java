package com.tsb.exception;

public class MatchIntervalIsFinishedException extends RuntimeException {
    public MatchIntervalIsFinishedException(String message) {
        super(message);
    }
    public MatchIntervalIsFinishedException(String message, Throwable cause) {
        super(message, cause);
    }

    public MatchIntervalIsFinishedException(Throwable cause) {
        super(cause);
    }
}
