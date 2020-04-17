package com.prueba.prueba.Controllers;

import com.prueba.prueba.models.Category;
import com.prueba.prueba.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        List<Category> categories = categoryService.findAll();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping(path = "{categoryId}")
    public ResponseEntity<?> findById(@PathVariable(name = "categoryId") Long categoryId){
        Category category = categoryService.findById(categoryId);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Category category){
        Category categorySaved = categoryService.save(category);
        return new ResponseEntity<>(categorySaved, HttpStatus.OK);
    }

    @PutMapping(path = "{categoryId}")
    public ResponseEntity<?> updateById(@PathVariable(name = "categoryId") Long categoryId,
                               @RequestBody Category newCategory){

        Category category = categoryService.findById(categoryId);
        category.setName(newCategory.getName());
        Category categorySaved = categoryService.save(category);
        return new ResponseEntity<>(categorySaved, HttpStatus.OK);
    }

    @DeleteMapping(path = "{categoryId}")
    public ResponseEntity<?> deleteById(@PathVariable(name = "categoryId") Long categoryId){
        categoryService.deleteById(categoryId);
        return new ResponseEntity<>("DELETED!", HttpStatus.OK);
    }
}
