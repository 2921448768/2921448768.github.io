package com.ljr.Excdption;

public class NotEnoughException extends  RuntimeException {
    public NotEnoughException() {
        super();
    }

    public NotEnoughException(String message) {
        super(message);
    }
}
