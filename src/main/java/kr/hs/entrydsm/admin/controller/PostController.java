package kr.hs.entrydsm.admin.controller;

import kr.hs.entrydsm.admin.service.PostService;
import kr.hs.entrydsm.admin.service.dto.PostRequest;
import kr.hs.entrydsm.common.security.JWTRequired;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.HandlerMethod;

import javax.validation.Valid;

@RequiredArgsConstructor
@JWTRequired
@RestController
@RequestMapping("/post")
public class PostController {
    private final PostService postService;

    @PostMapping
    public void createPost(@Valid @RequestBody PostRequest postRequest) {
        postService.createPost(postRequest);
    }

    @DeleteMapping("/{postId}")
    public void deletePost(@PathVariable long postId) {
        postService.deletePost(postId);
    }

    @PutMapping("/{postId}")
    public void updatePost(@PathVariable long postId, @Valid @RequestBody PostRequest postRequest) {
        postService.updatePost(postId, postRequest);
    }
}
