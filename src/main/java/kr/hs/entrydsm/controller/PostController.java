package kr.hs.entrydsm.controller;

import kr.hs.entrydsm.payload.response.*;
import kr.hs.entrydsm.service.club.ClubPostService;
import kr.hs.entrydsm.payload.request.PostRequest;
import kr.hs.entrydsm.service.like.LikeService;
import kr.hs.entrydsm.service.post.PostDetailService;
import kr.hs.entrydsm.service.post.PostService;
import kr.hs.entrydsm.security.JWTRequired;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostController {

    private final ClubPostService clubPostService;
    private final PostService postService;
    private final PostDetailService postDetailService;
    private final LikeService likeService;

    @JWTRequired
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/post")
    public void createPost(@Valid @RequestBody PostRequest postRequest) {
        clubPostService.createPost(postRequest);
    }

    @JWTRequired
    @DeleteMapping("/post/{postId}")
    public void deletePost(@PathVariable long postId) {
        clubPostService.deletePost(postId);
    }

    @JWTRequired
    @PutMapping("/post/{postId}")
    public void updatePost(@PathVariable long postId, @Valid @RequestBody PostRequest postRequest) {
        clubPostService.updatePost(postId, postRequest);
    }

    @JWTRequired
    @GetMapping("/post")
    public PostsResponse getPosts() {
        return clubPostService.getPosts();
    }

    @JWTRequired
    @GetMapping("/post/{postId}")
    public PostResponse getPost(@PathVariable long postId) {
        return clubPostService.getPost(postId);
    }

    @GetMapping("/main/post")
    public List<MainPostResponse> getPostList() {

        return postService.getListPost();

    }

    @GetMapping("/main/post/{postId}")
    public PostDetailResponse detailPosts(@PathVariable long postId) {

        return postDetailService.getDetailPost(postId);

    }

    @PostMapping("/main/post/like/{postId}")
    public void like(@PathVariable long postId) {

        likeService.createLike(postId);

    }

    @GetMapping("/main/post/best")
    public RecommendPageResponse bestPost(Pageable page) {

        return likeService.bestPostList(page);

    }

}
