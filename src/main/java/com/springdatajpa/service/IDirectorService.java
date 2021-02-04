package com.springdatajpa.service;

import com.springdatajpa.entyty.Director;

import java.util.List;

public interface IDirectorService {
    List<Director> getDirectors();

    Director getDirectorById(long id);

    Director createDirector(Director director);

    Director updateDirector(long id, Director director);

    void deleteDirector(long id);
}
