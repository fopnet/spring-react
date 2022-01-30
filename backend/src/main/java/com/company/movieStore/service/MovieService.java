package com.company.movieStore.service;

import java.util.NoSuchElementException;

import com.company.movieStore.dto.MovieDTO;
import com.company.movieStore.repository.MovieRepository;

import org.springframework.data.domain.Page;
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
    public Page<MovieDTO> findAll(Pageable pageable) {
        return movieRepository.findAll(pageable).map(MovieDTO::new);
    }

    @Transactional(readOnly = true)
    public MovieDTO findById(Long id) {
        return this.movieRepository.findById(id).map(MovieDTO::new)
                .orElseThrow(() -> new NoSuchElementException("Movie not found"));
    }
}
