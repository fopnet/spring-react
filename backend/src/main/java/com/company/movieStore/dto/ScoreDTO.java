package com.company.movieStore.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScoreDTO implements Serializable {

    private String email;
    private Long movieId;
    private Double score;
}
