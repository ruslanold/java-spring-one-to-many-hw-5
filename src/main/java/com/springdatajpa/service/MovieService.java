package com.springdatajpa.service;

import com.springdatajpa.dao.MovieRepository;
import com.springdatajpa.dto.MovieCreateDto;
import com.springdatajpa.dto.MovieDto;
import com.springdatajpa.entyty.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService implements IMovieService {

    private MovieRepository movieRepository;
    private IDirectorService directorService;

    @Autowired
    public MovieService(MovieRepository movieRepository, IDirectorService directorService) {
        this.movieRepository = movieRepository;
        this.directorService = directorService;
    }

    @Override
    public MovieDto createMovie(MovieCreateDto movie) {
        Movie movieEntyty = new Movie();
        movieEntyty.setTitle(movie.getTitle());
        movieEntyty.setGenre(movie.getGenre());
        movieEntyty.setDuration(movie.getDuration());
        movieEntyty.setDirector(directorService.getDirectorById(movie.getDirectorId()));
        return convertToMovieDto(movieRepository.saveAndFlush(movieEntyty));
    }

    @Override
    public List<MovieDto> getMovies() {
        return movieRepository.findAll().stream().map((movie) -> convertToMovieDto(movie)).collect(Collectors.toList());
    }

    @Override
    public MovieDto getMovieById(long id) {
        return convertToMovieDto(movieRepository.getOne(id));
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

    private MovieDto convertToMovieDto(Movie movie){
        return new MovieDto(movie.getId(), movie.getTitle(), movie.getGenre(), movie.getDuration(), movie.getDirector().getName());
    }
}
