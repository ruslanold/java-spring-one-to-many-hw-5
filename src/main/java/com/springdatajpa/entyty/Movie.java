package com.springdatajpa.entyty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    //@UniqueMovieTitle
    private String title;
    @NotBlank
    private String genre;
    @Positive
    @Max(value = 200, message = "Duration should not exceed 200")
    private int duration;

    @ManyToOne(targetEntity = Director.class, fetch = FetchType.LAZY)
    @JsonIgnore
    private Director director;
//
//    @ManyToOne(targetEntity = Director.class)
//    private Director directorRewarded;
}
