package com.back.global;

import com.back.domain.post.post.document.Post;
import com.back.domain.post.post.service.PostService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@RequiredArgsConstructor
@Configuration
@Slf4j
public class BaseInitData {
    private final PostService postService;
    @Bean
    public ApplicationRunner baseInitDataRunner(){
        return args -> {
            work1();
            work2();
            work3();
        };
    }

    private void work1(){
        log.debug("Post entity 개수: {}",postService.count());
        log.debug("샘플 Post 데이터 생성");
        if (postService.count() == 0){
            for (int i = 1; i <= 10; i++) {
                String title = "Sample Post Title " + i;
                String content = "This is the content of sample post number " + i + ".";
                String author = "Author" + i;
                Post post = postService.create(title, content, author);
                log.debug("Created Post: {}", post); // toString이 실행됨
            }
        }
    }

    private void work2(){
        log.debug("기존 Post 전체 조회");
        for (Post post : postService.findAll()) {
            log.debug("Existing Post: {}", post);
        }
    }

    private void work3(){
        log.debug("기존 Post 단건 조회");
        for (Post post : postService.findAll()) {
            Post postRow = postService.findById(post.getId()).get();
            log.debug("조회된 Post: {}", postRow);
        }
    }
}
