package com.springdatajpa.validator;

import com.springdatajpa.dto.MovieCreateDto;
import org.apache.commons.lang3.CharUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class MovieValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.isAssignableFrom(MovieCreateDto.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        MovieCreateDto movie = (MovieCreateDto) o;
        char firstLetter = movie.getTitle().charAt(0);
        if(!CharUtils.isAsciiAlphaUpper(firstLetter)) {
            errors.rejectValue("title", "title-capital-letter","Title should start with capital letter");
        }
    }

}
