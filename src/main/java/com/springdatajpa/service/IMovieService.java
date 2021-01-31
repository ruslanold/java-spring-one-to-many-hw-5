package com.springdatajpa.service;

import com.springdatajpa.entyty.Movie;

import java.util.List;

public interface IMovieService {

    Movie createMovie(Movie movie);

    List<Movie> getMovies();

    Movie getMovieById(long id);

    Movie updateMovie(long id, Movie movie);

    void deleteMovie(long id);


}
