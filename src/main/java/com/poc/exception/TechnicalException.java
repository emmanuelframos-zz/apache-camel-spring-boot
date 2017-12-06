package com.poc.exception;

public class TechnicalException extends RuntimeException {
    public TechnicalException(String msg, Throwable e) {
        super(msg, e);
    }

    public TechnicalException(String msg) {
        super(msg);
    }
}
