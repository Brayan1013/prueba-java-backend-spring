package com.prueba.prueba.services;

import com.prueba.prueba.models.Author;

import java.util.List;

public interface AuthorService {
    List<Author> findAll();
    Author save(Author author);
    void deleteById(Long id);
    Author findById(Long id);
}
