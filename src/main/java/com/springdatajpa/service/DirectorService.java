package com.springdatajpa.service;

import com.springdatajpa.dao.DirectorRepository;
import com.springdatajpa.dto.BadRequestException;
import com.springdatajpa.entyty.Director;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectorService implements IDirectorService{

    private DirectorRepository directorRepository;

    @Autowired
    public DirectorService(DirectorRepository directorRepository){
        this.directorRepository = directorRepository;
    }

    @Override
    public List<Director> getDirectors() {
        return directorRepository.findAll();
    }

    @Override
    public Director getDirectorById(long id) {
        if(!directorRepository.existsById(id)){
            throw new BadRequestException("No director with such id: " + id);
        }
        return directorRepository.getOne(id);
    }

    @Override
    public Director createDirector(Director director) {
        return directorRepository.saveAndFlush(director);
    }

    @Override
    public Director updateDirector(long id, Director director) {
        if(!directorRepository.existsById(id)){
            throw new IllegalArgumentException("No director with such id: " + id);
        }
        return directorRepository.saveAndFlush(director);
    }

    @Override
    public void deleteDirector(long id) {
        if(!directorRepository.existsById(id)){
            throw new IllegalArgumentException("No director with such id: " + id);
        }
        directorRepository.deleteById(id);
    }
}
