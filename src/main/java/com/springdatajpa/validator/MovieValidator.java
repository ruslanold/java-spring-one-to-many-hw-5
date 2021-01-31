package com.springdatajpa.validator;

import com.springdatajpa.entyty.Movie;
import org.apache.commons.lang3.CharUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.Constraint;

public class MovieValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.isAssignableFrom(Movie.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Movie movie = (Movie) o;
        char firstLetter = movie.getTitle().charAt(0);
        if(!CharUtils.isAsciiAlphaUpper(firstLetter)) {
            errors.rejectValue("title", "title-capital-letter","Title should start with capital letter");
        }
    }

}
