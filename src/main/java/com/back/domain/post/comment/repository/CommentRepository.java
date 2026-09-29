package com.back.domain.post.comment.repository;

import com.back.domain.post.comment.Comment;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface CommentRepository extends ElasticsearchRepository<Comment, String> {
}
