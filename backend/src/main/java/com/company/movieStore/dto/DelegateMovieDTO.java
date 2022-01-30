package com.company.movieStore.dto;

import java.io.Serializable;
import java.util.Set;

import com.company.movieStore.entity.Score;
import com.fasterxml.jackson.annotation.JsonIgnore;

public interface DelegateMovieDTO extends Serializable {

    Long getId();

    void setId(Long id);

    String getTitle();

    void setTitle(String title);

    Double getScore();

    void setScore(Double score);

    Integer getCount();

    void setCount(Integer count);

    String getImage();

    void setImage(String image);

    @JsonIgnore
    Set<Score> getScores();

    void setScores(Set<Score> stores);
}
