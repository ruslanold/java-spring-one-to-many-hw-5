package com.springdatajpa.service;

import com.springdatajpa.dao.MovieRepository;
import com.springdatajpa.entyty.Movie;
import org.apache.commons.lang3.CharUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class MovieService implements IMovieService {

    private MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie createMovie(Movie movie) {
        return movieRepository.saveAndFlush(movie);
    }

    @Override
    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Movie getMovieById(long id) {
        return movieRepository.getOne(id);
    }

    @Override
    public Movie updateMovie(long id, Movie movie) {
        if(!movieRepository.existsById(id)) {
            throw new IllegalArgumentException("No movie with such id: " + id);
        }
        movie.setId(id);
        return movieRepository.saveAndFlush(movie);
    }

    @Override
    public void deleteMovie(long id) {
        if(!movieRepository.existsById(id)) {
            throw new IllegalArgumentException("No movie with such id: " + id);
        }
        movieRepository.deleteById(id);
    }
}
