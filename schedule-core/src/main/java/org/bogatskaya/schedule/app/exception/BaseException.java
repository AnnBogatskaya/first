package org.bogatskaya.schedule.app.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseException extends RuntimeException{

    private static final Long SERIAL_UID = 1657654234674L;

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseException.class);


    public BaseException(final String mesaage, Throwable cause){
        super(mesaage,cause);
    }

    public BaseException(final String message){
        LOGGER.error(message);
    }

    public BaseException(String message, Long id) {
        LOGGER.error(message, id);
    }

    public BaseException(String message, String parameter) {
        LOGGER.error(message, parameter);
    }
}
