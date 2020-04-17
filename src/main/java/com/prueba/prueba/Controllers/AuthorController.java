package com.prueba.prueba.Controllers;

import com.prueba.prueba.models.Author;
import com.prueba.prueba.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/authors")
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        List<Author> authors = authorService.findAll();
        return new ResponseEntity<>(authors, HttpStatus.OK);
    }

    @GetMapping(path = "{authorId}")
    public ResponseEntity<?> findById(@PathVariable(name = "authorId") Long authorId){
        Author authorById = authorService.findById(authorId);
        return new ResponseEntity<>(authorById, HttpStatus.OK);
    }

    @PutMapping(path = "{authorId}")
    public ResponseEntity<?> updateById(@PathVariable(name = "authorId") Long authorId, @RequestBody Author newAuthor){
        Author author = authorService.findById(authorId);
        author.setAuthorscol(newAuthor.getAuthorscol());
        author.setEmail(newAuthor.getEmail());
        author.setName(newAuthor.getName());
        author.setUserName(newAuthor.getUserName());
        Author userSaved = authorService.save(author);
        return new ResponseEntity<>(userSaved, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Author author){
       Author authorSaved = authorService.save(author);
        return new ResponseEntity<>(authorSaved, HttpStatus.OK);
    }

    @DeleteMapping(path = "{authorId}")
    public ResponseEntity<?> deleteById(@PathVariable(name = "authorId") Long authorId){
        authorService.deleteById(authorId);
        return new ResponseEntity<>("DELETED!", HttpStatus.OK);
    }
}
