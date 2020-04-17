package com.prueba.prueba.daos;

import com.prueba.prueba.models.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryDao extends CrudRepository<Category, Long> {
}
