package com.prueba.prueba.services;

import com.prueba.prueba.models.Post;

import java.util.List;

public interface PostService {
    List<Post> findAll();
    Post findById(Long id);
    Post save(Post post);
    void deleteById(Long id);

}
