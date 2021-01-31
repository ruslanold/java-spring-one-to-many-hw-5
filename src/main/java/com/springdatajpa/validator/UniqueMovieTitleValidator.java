package com.springdatajpa.validator;

import com.springdatajpa.dao.MovieRepository;
import com.springdatajpa.entyty.Movie;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@NoArgsConstructor
public class UniqueMovieTitleValidator implements ConstraintValidator<UniqueMovieTitle, String> {

    private MovieRepository movieRepository;

    @Autowired
    public UniqueMovieTitleValidator(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public void initialize(UniqueMovieTitle constraintAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        final Movie movie = movieRepository.findByTitle(s);
        return movie == null;
    }
}
