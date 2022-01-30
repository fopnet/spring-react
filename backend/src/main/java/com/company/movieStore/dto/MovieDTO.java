package com.company.movieStore.dto;

import com.company.movieStore.entity.Movie;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Delegate;

@Data
// @AllArgsConstructor(access = AccessLevel.PACKAGE)
// @NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "movie")
@ToString
public class MovieDTO implements DelegateMovieDTO {

    /**
     * Forma de manter as propriedades delegadas, mas sem
     * repetir o atribuito movie
     */
    @Getter(AccessLevel.PACKAGE)
    @Setter(AccessLevel.PRIVATE)
    @Delegate(types = DelegateMovieDTO.class)
    private Movie movie = new Movie();
}
