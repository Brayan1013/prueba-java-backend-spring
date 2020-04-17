package com.prueba.prueba.services;

import com.prueba.prueba.daos.AuthorDao;
import com.prueba.prueba.models.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorImpl implements AuthorService {

    private final AuthorDao authorDao;

    @Autowired
    public AuthorImpl(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }


    @Override
    public List<Author> findAll() {
        return (List<Author>) authorDao.findAll();
    }

    @Override
    public Author save(Author author) {
        return authorDao.save(author);
    }

    @Override
    public void deleteById(Long id) {
        authorDao.deleteById(id);
    }

    @Override
    public Author findById(Long id) {
        return authorDao.findById(id).orElseThrow(() ->
                new IllegalStateException(String.format("the user with the id %s does not exist", id)));
    }
}
