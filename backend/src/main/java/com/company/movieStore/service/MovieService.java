package com.company.movieStore.service;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.NoSuchElementException;

import com.company.movieStore.dto.MovieDTO;
import com.company.movieStore.repository.MovieRepository;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Transactional(readOnly = true)
    public List<MovieDTO> findAll(Pageable pageable) {
        return this.movieRepository.findAll(pageable).stream().map(MovieDTO::new).collect(toList());
    }

    @Transactional(readOnly = true)
    public MovieDTO findById(Long id) {
        return this.movieRepository.findById(id).map(MovieDTO::new)
                .orElseThrow(() -> new NoSuchElementException("Movie not found"));
    }
}
