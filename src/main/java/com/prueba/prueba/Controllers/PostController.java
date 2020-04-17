package com.prueba.prueba.Controllers;

import com.prueba.prueba.models.Post;
import com.prueba.prueba.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/post")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        List<Post> posts = postService.findAll();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @GetMapping(path = "{postId}")
    public ResponseEntity<?> findById(@PathVariable(name = "postId") Long postId){
        Post post = postService.findById(postId);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Post post){
        Post postSaved = postService.save(post);
        return new ResponseEntity<>(postSaved, HttpStatus.OK);
    }

    @PutMapping(path = "{postId}")
    public ResponseEntity<?> updateById(@RequestParam(name = "postId") Long postId, @RequestParam Post newPost){
        Post post = postService.findById(postId);
        post.setLikes(newPost.getLikes());
        post.setTitle(newPost.getTitle());
        post.setContent(newPost.getContent());

        Post postSaved = postService.save(post);
        return new ResponseEntity<>(postSaved, HttpStatus.OK);
    }

    @DeleteMapping(path = "{postId}")
    public ResponseEntity<?> deleteById(@PathVariable(name = "postId") Long postId){
        postService.deleteById(postId);
        return new ResponseEntity<>("DELETED!", HttpStatus.OK);
    }
}
