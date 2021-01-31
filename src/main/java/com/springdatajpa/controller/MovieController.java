package com.springdatajpa.controller;

import com.springdatajpa.entyty.Movie;
import com.springdatajpa.service.IMovieService;
import com.springdatajpa.validator.MovieValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@Slf4j
@RestController
@RequestMapping(value = "/movies")
public class MovieController {

    @Autowired
    private IMovieService movieService;

    //private static Logger Logger = LoggerFactory.getLogger(MovieController.class);

    @GetMapping()
    public List<Movie> getMovies(){
        return movieService.getMovies();
    }

    @GetMapping(value = "/{id}")
    public Movie getMovie(@PathVariable long id){
        return movieService.getMovieById(id);
    }

    @PostMapping()
    @ResponseStatus(value = HttpStatus.CREATED)
    public Movie createMovie(@RequestBody @Valid Movie movie){
        log.info("Handled POST request with body: {}", movie);
        return movieService.createMovie(movie);
    }

    @PutMapping(value = "/{id}")
    public Movie updateMovie(@PathVariable long id, @RequestBody @Valid Movie movie){
        return movieService.updateMovie(id, movie);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteMovie(@PathVariable long id){
        movieService.deleteMovie(id);
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(new MovieValidator());
    }
}
