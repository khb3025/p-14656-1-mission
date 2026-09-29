package com.back.domain.post.post.service;

import com.back.domain.post.comment.repository.CommentRepository;
import com.back.domain.post.post.document.Post;
import com.back.domain.post.post.repository.PostRepository;
import com.back.global.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postResitory;
    private final CommentRepository commentRepository;

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
    public Post update(String id, String title, String content){
        Post post = this.findById(id);
        if(title != null) post.setTitle(title);
        if(content != null) post.setContent(content);
        return postResitory.save(post);
    }

    public void delete(String id){
        Post post = findById(id);
        postResitory.delete(post);
        // commentRepository.deleteByPostId(id);
    }
}
