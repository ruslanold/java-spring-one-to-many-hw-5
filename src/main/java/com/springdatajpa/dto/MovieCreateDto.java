package com.springdatajpa.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class MovieCreateDto {
    private String title;
    private String genre;
    private int duration;
    private long directorId;
}
