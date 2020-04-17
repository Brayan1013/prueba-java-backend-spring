package com.prueba.prueba.services;

import com.prueba.prueba.daos.CategoryDao;
import com.prueba.prueba.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryImpl implements CategoryService {

    private final CategoryDao categoryDao;

    @Autowired
    public CategoryImpl(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public List<Category> findAll() {
        return (List<Category>) categoryDao.findAll();
    }

    @Override
    public Category save(Category category) {
        return categoryDao.save(category);
    }

    @Override
    public Category findById(Long id) {
        return categoryDao.findById(id)
                .orElseThrow(() -> new IllegalStateException("NOT FOUND"));
    }

    @Override
    public void deleteById(Long id) {
         categoryDao.deleteById(id);
    }
}
