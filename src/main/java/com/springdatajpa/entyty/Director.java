package com.springdatajpa.entyty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String name;

    //    @JsonFormat(pattern = "yyyy-mm-dd")
    private LocalDate birthDate;

    @OneToMany(mappedBy = "director", fetch = FetchType.LAZY)
    //@JoinColumn(name = "director_id")
    private Set<Movie> movies = new HashSet<>();

//    @OneToMany(mappedBy = "directorRewarded")
//    private Set<Movie> awardMovies = new HashSet<>();


}
