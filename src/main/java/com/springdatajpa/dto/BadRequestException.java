package com.springdatajpa.dto;

public class BadRequestException extends RuntimeException{

    public BadRequestException(String message){
        super(message);
    }
}
