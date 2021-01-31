package com.springdatajpa.dao;

import com.springdatajpa.entyty.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Query("Select m from Movie m where m.title like :title")
    Movie findByTitle(String title);
}
