package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by lubov on 04.09.20.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RecordNotFoundException extends Exception {

    private static final long serialVerdionUID = 1L;

    public RecordNotFoundException(String message) {

        super(message);
    }

    public RecordNotFoundException(String message, Throwable t) {
        super(message, t);
    }
}
