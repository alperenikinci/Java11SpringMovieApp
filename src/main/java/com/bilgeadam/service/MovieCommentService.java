package com.bilgeadam.service;


import com.bilgeadam.repository.IMovieCommentRepository;
import com.bilgeadam.repository.entity.MovieComment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieCommentService implements IServiceCrud<MovieComment>{
    private final IMovieCommentRepository movieCommentRepository;


    @Override
    public MovieComment save(MovieComment movieComment) {
        return movieCommentRepository.save(movieComment);
    }

    @Override
    public Iterable<MovieComment> saveAll(Iterable<MovieComment> t) {
        return movieCommentRepository.saveAll(t);
    }

    @Override
    public MovieComment update(MovieComment movieComment) {
        return null;
    }

    @Override
    public void delete(MovieComment movieComment) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<MovieComment> findAll() {
        return movieCommentRepository.findAll();
    }

    @Override
    public Optional<MovieComment> findById(Long id) {
        return movieCommentRepository.findById(id);
    }
}
