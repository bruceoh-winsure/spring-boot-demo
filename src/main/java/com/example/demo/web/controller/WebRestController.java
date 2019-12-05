package com.example.demo.web.controller;

import com.example.demo.data.domain.PostsRepository;
import com.example.demo.web.dto.PostsSaveRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class WebRestController {

    private PostsRepository postsRepository;


    @GetMapping("/hello")
    public String hello(){
        return "hello world";
    }

    @PostMapping("/posts")      //@setter => controller에서 @requestbody로 외부 데이터를 받는 경우엔 기본생성자 + set메소드로만 값이 할당
    public void savePosts(@RequestBody PostsSaveRequestDto dto){
        postsRepository.save((dto.toEntity()));
    }
}
