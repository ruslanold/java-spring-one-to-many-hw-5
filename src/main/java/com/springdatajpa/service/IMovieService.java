package com.springdatajpa.service;

import com.springdatajpa.dto.MovieCreateDto;
import com.springdatajpa.dto.MovieDto;
import com.springdatajpa.entyty.Movie;

import java.util.List;

public interface IMovieService {

    MovieDto createMovie(MovieCreateDto movie);

    List<MovieDto> getMovies();

    MovieDto getMovieById(long id);

    Movie updateMovie(long id, Movie movie);

    void deleteMovie(long id);


}
