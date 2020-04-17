package com.prueba.prueba.daos;

import com.prueba.prueba.models.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorDao extends CrudRepository<Author, Long> {
}
