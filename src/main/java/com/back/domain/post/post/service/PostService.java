package com.back.domain.post.post.service;

import com.back.domain.post.post.document.Post;
import com.back.domain.post.post.repository.PostRepository;
import com.back.global.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postResitory;
    public long count() {
        return postResitory.count();
    }

    public Post create(String title, String content, String author){
        Post post = new Post(
                title,
                content,
                author
        );
        return postResitory.save(post);
    }

    public List<Post> findAll(){
        return postResitory.findAll();
    }

    public Post findById(String id){
        return postResitory.findById(id).orElseThrow(
                () -> new NotFoundException("Post not found with id: " + id)
        );
    }
}
