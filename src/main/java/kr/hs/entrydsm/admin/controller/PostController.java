package kr.hs.entrydsm.admin.controller;

import kr.hs.entrydsm.admin.service.ClubPostService;
import kr.hs.entrydsm.admin.service.dto.PostRequest;
import kr.hs.entrydsm.admin.service.dto.PostResponse;
import kr.hs.entrydsm.admin.service.dto.PostsResponse;
import kr.hs.entrydsm.common.security.JWTRequired;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@JWTRequired
@RestController
@RequestMapping("/admin/post")
public class PostController {
    private final ClubPostService clubPostService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createPost(@Valid @RequestBody PostRequest postRequest) {
        clubPostService.createPost(postRequest);
    }

    @DeleteMapping("/{postId}")
    public void deletePost(@PathVariable long postId) {
        clubPostService.deletePost(postId);
    }

    @PutMapping("/{postId}")
    public void updatePost(@PathVariable long postId, @Valid @RequestBody PostRequest postRequest) {
        clubPostService.updatePost(postId, postRequest);
    }

    @GetMapping
    public PostsResponse getPosts() {
        return clubPostService.getPosts();
    }

    @GetMapping("/{postId}")
    public PostResponse getPost(@PathVariable long postId) {
        return clubPostService.getPost(postId);
    }
}
