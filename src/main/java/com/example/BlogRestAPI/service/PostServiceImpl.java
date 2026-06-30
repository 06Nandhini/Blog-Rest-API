package com.example.BlogRestAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BlogRestAPI.dto.RequestDto.PostRequestDto;
import com.example.BlogRestAPI.dto.ResponseDto.PostResponseDto;
import com.example.BlogRestAPI.entity.Post;
import com.example.BlogRestAPI.repository.PostRepository;
import java.util.ArrayList;

@Service
public class PostServiceImpl implements PostService{
    
    @Autowired
    private PostRepository postRepository;


    //helper method to convert Post entity to PostResponseDto
    
    private PostResponseDto mapToResponse(Post post){

        PostResponseDto response =
            new PostResponseDto();

        response.setId(post.getId());
        response.setTitle(post.getTitle());
        response.setContent(post.getContent());
        response.setAuthor(post.getAuthor());

        return response;
    }

    private Post mapToEntity(PostRequestDto postRequestDto){

        Post post = new Post();
        post.setTitle(postRequestDto.getTitle());
        post.setContent(postRequestDto.getContent());
        return post;
    }

    @Override
    public PostResponseDto createPost(PostRequestDto post){
        Post postEntity = mapToEntity(post);
        Post savedPost = postRepository.save(postEntity);
        PostResponseDto response = mapToResponse(savedPost);
        return response;
    }

    @Override
    public List<PostResponseDto> getAllposts() {
        List<PostResponseDto> response = new ArrayList<>();
        for(Post post : postRepository.findAll()){
            response.add(mapToResponse(post));
        }
        return response;

    }

    @Override
    public PostResponseDto getPostById(Long id) {
        Post post = postRepository.findById(id).orElseThrow(()-> new RuntimeException("Post not found"));
        return mapToResponse(post);
    }

    @Override
    public PostResponseDto updatePost(Long id, PostRequestDto post) {
        Post existingPost = postRepository.findById(id).orElse(new Post());
        existingPost.setTitle(post.getTitle());
        existingPost.setContent(post.getContent());
        postRepository.save(existingPost);
        return mapToResponse(existingPost);
    }

    @Override
    public void deletePost(Long id) {
        Post existingPost = postRepository.findById(id).orElseThrow(()-> new RuntimeException("Post not found"));
        postRepository.delete(existingPost);   
    }

}
