package com.freeit.onlinestore.exception.handler;

import com.freeit.onlinestore.exception.DBNotFoundException;
import com.freeit.onlinestore.exception.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value={DBNotFoundException.class})
    public ResponseEntity<Object> handleDBNotFoundException(DBNotFoundException e) {
        ExceptionDto exceptionDto = new ExceptionDto(
                e.getMessage(),
                e, HttpStatus.NOT_FOUND,
                LocalDateTime.now()
        );
        return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
    }
}
