package com.back.domain.post.comment.repository;

import com.back.domain.post.comment.Comment;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface CommentRepository extends ElasticsearchRepository<Comment, String> {
    List<Comment> findAll();

    List<Comment> findByPostId(String postId);

    // void deleteByPostId(String postId);
}
