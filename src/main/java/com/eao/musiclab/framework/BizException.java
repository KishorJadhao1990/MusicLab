package com.eao.musiclab.framework;

public class BizException extends RuntimeException {

    public BizException() {
        super("Something is wrong!");
    }
    public BizException(String message) {
        super(message);
    }
    public BizException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
