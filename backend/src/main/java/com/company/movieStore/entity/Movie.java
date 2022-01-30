package com.company.movieStore.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.company.movieStore.dto.DelegateMovieDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = { "id" })
@Entity
@Table(name="tb_movie")
public class Movie implements DelegateMovieDTO {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Double score;
    private Integer count;
    private String image;

    // o objetico de ser eager,
    // é que ao serializar o objeto a sessao já estará fechada
    @OneToMany(mappedBy = "id.movie", fetch = FetchType.LAZY)
    // @JsonBackReference // evitar loop
    private Set<Score> scores = new HashSet<>();

}
