package org.bogatskaya.schedule.app.exception;

public class NotFoundException extends BaseException{

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Long id) {
        super(message,id);
    }

    public NotFoundException(String message, String parameter) {
        super(message, parameter);
    }
}
