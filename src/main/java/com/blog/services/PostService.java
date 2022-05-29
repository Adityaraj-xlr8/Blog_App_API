package com.blog.services;

import com.blog.entities.Category;
import com.blog.entities.Post;
import com.blog.payloads.CategoryDto;
import com.blog.payloads.PostDto;
import com.blog.payloads.PostResponse;

import java.util.List;

public interface PostService {

    //create post
    PostDto createPost(PostDto postDto,Integer userId,Integer categoryId);

    //update post
    PostDto updatePost(PostDto postDto,Integer postId);

    //delete post
    void deletePost(Integer postId);

    //get all posts
    PostResponse getAllPosts(Integer pageNumber, Integer pageSize,String sortBy,String sortDir);

    //get single post
    PostDto getPostById(Integer postId);

    //get all posts by a category
    List<PostDto> getPostByCategory(Integer categoryId);

    //get all posts by a user
    PostResponse getAllPostsByUser(Integer userId,Integer pageNumber,Integer pageSize);

    //search post
    List<PostDto>  searchPost(String keyword);

}
