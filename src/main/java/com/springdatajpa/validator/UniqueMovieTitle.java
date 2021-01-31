package com.springdatajpa.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = UniqueMovieTitleValidator.class)
@Target({FIELD})
@Retention(RUNTIME)
public @interface UniqueMovieTitle {
    String message() default "Movie title should be unique";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
