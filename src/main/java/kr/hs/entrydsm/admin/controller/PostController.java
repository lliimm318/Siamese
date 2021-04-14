package kr.hs.entrydsm.admin.controller;

import kr.hs.entrydsm.admin.service.PostService;
import kr.hs.entrydsm.admin.service.dto.PostRequest;
import kr.hs.entrydsm.admin.service.dto.PostResponse;
import kr.hs.entrydsm.admin.service.dto.PostsResponse;
import kr.hs.entrydsm.common.security.JWTRequired;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.HandlerMethod;

import javax.validation.Valid;

@RequiredArgsConstructor
@JWTRequired
@RestController
@RequestMapping("/post")
public class PostController {
    private final PostService postService;

    @ResponseStatus(HttpStatus.CREATED)
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

    @GetMapping
    public PostsResponse getPosts() {
        return postService.getPosts();
    }

    @GetMapping("/{postId}")
    public PostResponse getPost(@PathVariable long postId) {
        return postService.getPost(postId);
    }
}
