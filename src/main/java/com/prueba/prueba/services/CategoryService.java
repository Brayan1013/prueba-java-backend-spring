package com.prueba.prueba.services;

import com.prueba.prueba.models.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Category save(Category category);
    Category findById(Long id);
    void deleteById(Long id);
}
