package com.company.movieStore.dto;

import java.io.Serializable;

import com.company.movieStore.entity.Movie;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Delegate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDTO implements Serializable {

    @Delegate(types = Movie.class)
    @Getter(AccessLevel.PACKAGE)
    @Setter(AccessLevel.PRIVATE)
    private Movie movie = new Movie();
    // private Long id;
    // private String title;
    // private Double score;
    // private Integer count;
    // private String image;
}
