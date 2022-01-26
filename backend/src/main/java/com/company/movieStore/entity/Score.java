package com.company.movieStore.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Delegate;

@Data
@EqualsAndHashCode(of={"id"})
@Entity
@Table(name = "tb_score")
@AllArgsConstructor
@NoArgsConstructor
public class Score implements Serializable {
    
    @Getter(AccessLevel.PACKAGE)
    @Setter(AccessLevel.PRIVATE)
    @EmbeddedId
    @Delegate(types = ScorePk.class)
    private ScorePk id;
    private Double value;
}
