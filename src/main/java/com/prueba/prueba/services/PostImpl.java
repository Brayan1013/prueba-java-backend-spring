package com.prueba.prueba.services;

import com.prueba.prueba.daos.PostDao;
import com.prueba.prueba.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.util.List;

@Service
public class PostImpl implements PostService {
    private final PostDao postDao;

    @Autowired
    public PostImpl(PostDao postDao) {
        this.postDao = postDao;
    }

    @Override
    public List<Post> findAll() {
        return (List<Post>) postDao.findAll();
    }

    @Override
    public Post findById(Long id) {
        return postDao.findById(id).orElseThrow(()->
                new IllegalStateException("Post not found"));
    }

    @Override
    public Post save(Post post) {
        return postDao.save(post);
    }

    @Override
    public void deleteById(Long id) {
        postDao.deleteById(id);
    }
}
