package com.prueba.prueba.daos;

import com.prueba.prueba.models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostDao extends CrudRepository<Post, Long> {
}
