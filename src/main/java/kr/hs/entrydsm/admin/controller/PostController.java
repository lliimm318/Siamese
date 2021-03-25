package kr.hs.entrydsm.admin.controller;

import kr.hs.entrydsm.admin.service.PostService;
import kr.hs.entrydsm.admin.service.dto.PostRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/post")
public class PostController {
    private final PostService postService;

    @PostMapping
    public void createPost(@Valid @RequestBody PostRequest postRequest) {
        postService.createPost(postRequest);
    }

    @DeleteMapping
    public void deletePost(@PathVariable int postId) {
        postService.deletePost(postId);
    }

    @PutMapping
    public void updatePost(@PathVariable int postId, @Valid @RequestBody PostRequest postRequest) {
        postService.updatePost(postId, postRequest);
    }
}
