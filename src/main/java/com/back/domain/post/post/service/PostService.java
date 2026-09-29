package com.back.domain.post.post.service;

import com.back.domain.post.post.document.Post;
import com.back.domain.post.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
