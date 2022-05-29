package com.blog.controllers;

import com.blog.payloads.ApiResponse;
import com.blog.payloads.CategoryDto;
import com.blog.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    //create
    @PostMapping("/")
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto){
            CategoryDto addedCategory=categoryService.createCategory(categoryDto);
            return new ResponseEntity<CategoryDto>(addedCategory, HttpStatus.CREATED);
    }

    //update
    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto,@PathVariable("categoryId") Integer catId){
        CategoryDto updatedCategory=categoryService.updateCategory(categoryDto,catId);
        return new ResponseEntity<CategoryDto>(updatedCategory, HttpStatus.OK);
    }

    //delete
    @DeleteMapping("/{categoryId}")
    public ResponseEntity<ApiResponse> updateCategory(@PathVariable("categoryId") Integer catId){
        categoryService.deleteCategory(catId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("category is deleted succesfully",true), HttpStatus.OK);
    }


    //get
    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> getCategory(@PathVariable("categoryId") Integer catId){
        CategoryDto categoryDto=categoryService.getCategory(catId);
        return new ResponseEntity<CategoryDto>(categoryDto, HttpStatus.OK);
    }

    //getAll
    @GetMapping("/")
    public ResponseEntity<List<CategoryDto>> getAllCategory(){
        return ResponseEntity.ok(this.categoryService.getAllCategory());
    }

}
