package com.company.movieStore.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of={"id"})
@Entity
@Table(name = "tb_score")
public class Score implements Serializable {
    
    @EmbeddedId
    private ScorePk id;
    private Double value;
}
