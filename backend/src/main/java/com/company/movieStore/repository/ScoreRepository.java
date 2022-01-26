package com.company.movieStore.repository;

import com.company.movieStore.entity.Score;
import com.company.movieStore.entity.ScorePk;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreRepository extends JpaRepository<Score, ScorePk> {

}
