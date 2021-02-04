package com.springdatajpa.controller;


import com.springdatajpa.entyty.Director;
import com.springdatajpa.service.IDirectorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/directors")
public class DirectorController {

    private IDirectorService directorService;

    @GetMapping()
    @ResponseStatus(value = HttpStatus.OK)
    public List<Director> getDirectors(){
        return directorService.getDirectors();
    }

    @GetMapping(value = "{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Director getDirectorByID(@PathVariable long id){
        return directorService.getDirectorById(id);
    }

    @PostMapping()
    @ResponseStatus(value = HttpStatus.CREATED)
    public Director createDirector(Director director){
        return directorService.createDirector(director);
    }

    @PutMapping(value = "{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Director updateDirector(@PathVariable long id, @RequestBody Director director){
        return directorService.updateDirector(id,director);
    }

    @DeleteMapping(value = "{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteDirector(@PathVariable long id){
        directorService.deleteDirector(id);
    }
}
