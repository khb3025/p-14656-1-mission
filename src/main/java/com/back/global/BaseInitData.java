package com.back.global;

import com.back.domain.post.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;
@RequiredArgsConstructor
@Configuration
@Slf4j
public class BaseInitData {
    private final PostService postService;
    @Bean
    public ApplicationRunner baseInitDataRunner(){
        return args -> {
            work1();
        };
    }

    private void work1(){
        log.debug("Post entity 개수: {}",postService.count());
    }
}
