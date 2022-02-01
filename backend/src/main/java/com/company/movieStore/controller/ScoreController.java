package com.company.movieStore.controller;

import com.company.movieStore.dto.MovieDTO;
import com.company.movieStore.dto.ScoreDTO;
import com.company.movieStore.service.ScoreService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/scores")
public class ScoreController {
    private final ScoreService scoreService;

    public ScoreController(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    @PutMapping
    public ResponseEntity<MovieDTO> save(@RequestBody ScoreDTO dto) {
        return ResponseEntity.ok(this.scoreService.save(dto));
    }

}
