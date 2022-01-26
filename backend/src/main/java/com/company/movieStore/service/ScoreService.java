package com.company.movieStore.service;

import java.util.NoSuchElementException;
import java.util.Objects;

import com.company.movieStore.dto.MovieDTO;
import com.company.movieStore.dto.ScoreDTO;
import com.company.movieStore.entity.Movie;
import com.company.movieStore.entity.Score;
import com.company.movieStore.entity.ScorePk;
import com.company.movieStore.entity.User;
import com.company.movieStore.repository.MovieRepository;
import com.company.movieStore.repository.ScoreRepository;
import com.company.movieStore.repository.UserRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ScoreService {

    private final UserRepository userRepository;
    private final MovieRepository movieRepository;
    private final ScoreRepository scoreRepository;

    public ScoreService(UserRepository userRepository, MovieRepository movieRepository,
            ScoreRepository scoreRepository) {
        this.userRepository = userRepository;
        this.movieRepository = movieRepository;
        this.scoreRepository = scoreRepository;
    }

    @Transactional
    public MovieDTO save(ScoreDTO dto) {
        User user = userRepository.findByEmail(dto.getEmail());

        if (Objects.isNull(user)) {
            user = new User();
            user.setEmail(dto.getEmail());
            user = userRepository.save(user);
        }

        Movie movie = movieRepository.findById(dto.getMovieId())
                .orElseThrow(() -> new NoSuchElementException("Movie not found"));

        ScorePk id = new ScorePk(movie, user);
        Score score = new Score(id, dto.getScore());
        scoreRepository.saveAndFlush(score);

        Double average = movie.getScores().stream()
                .mapToDouble(Score::getValue) //
                .average()
                .getAsDouble();
        movie.setScore(average);
        movie.setCount(movie.getScores().size());

        movie = movieRepository.save(movie);

        return new MovieDTO(movie);
    }
}
