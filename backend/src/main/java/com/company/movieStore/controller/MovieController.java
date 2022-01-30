package com.company.movieStore.controller;

import com.company.movieStore.dto.MovieDTO;
import com.company.movieStore.service.MovieService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<Page<MovieDTO>> findAll(Pageable pageable) {
        return ResponseEntity.ok(this.movieService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDTO> findAll(@PathVariable Long id) {
        return ResponseEntity.ok(this.movieService.findById(id));
    }

}
