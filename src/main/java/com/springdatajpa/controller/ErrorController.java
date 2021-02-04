package com.springdatajpa.controller;

import com.springdatajpa.dto.BadRequestException;
import com.springdatajpa.dto.ResponseErrorDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
public class ErrorController {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseErrorDto handlerMethodArgumentNotValidException(MethodArgumentNotValidException exception){
        log.info(exception.getMessage());
        String message = parseValidationExeption(exception);
        return new ResponseErrorDto(HttpStatus.BAD_REQUEST.value(), LocalDateTime.now(), message );
    }

    @ExceptionHandler(value = BadRequestException.class)
    public ResponseErrorDto handleBadRequestException(BadRequestException exception) {
        log.info("Handled BadRequestException: {}", exception.getMessage());
        return new ResponseErrorDto(HttpStatus.BAD_REQUEST.value(), LocalDateTime.now(), exception.getMessage());
    }

    private String parseValidationExeption(MethodArgumentNotValidException exception) {
        List<String> defaultMessages = exception.getAllErrors().stream()
                .map(objectError -> objectError.getDefaultMessage())
                .collect(Collectors.toList());

        return defaultMessages.toString();
    }
}
