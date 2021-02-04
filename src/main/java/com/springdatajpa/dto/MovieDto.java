package com.springdatajpa.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class MovieDto {

    private long id;
    private String title;
    private String genre;
    private int duration;
    private String directorName;
}
