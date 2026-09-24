package com.example.blog.service;

import com.example.blog.dto.PostRequestDto;
import com.example.blog.exception.ResourceNotFoundException;
import com.example.blog.model.Post;
import com.example.blog.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post createPost(PostRequestDto dto) {
        Post post = new Post(
                dto.getTitle(),
                dto.getContent(),
                dto.getCategory(),
                dto.getTags()
        );
        return postRepository.save(post);
    }

    public Post getPostById(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found with id: " + id));
    }

    public List<Post> getAllPosts(String term, String tag) {
        if (tag != null && !tag.trim().isEmpty()) {
            return postRepository.findByTag(tag.trim());
        }
        if (term != null && !term.trim().isEmpty()) {
            return postRepository.searchPosts(term.trim());
        }
        return postRepository.findAll();
    }

    public Post updatePost(Long id, PostRequestDto dto) {
        Post post = getPostById(id);

        post.setTitle(dto.getTitle());
        post.setContent(dto.getContent());
        post.setCategory(dto.getCategory());
        post.setTags(dto.getTags());

        return postRepository.save(post);
    }

    public void deletePost(Long id) {
        Post post = getPostById(id);
        postRepository.delete(post);
    }
}