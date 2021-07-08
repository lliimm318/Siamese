package kr.hs.entrydsm.controller;

import kr.hs.entrydsm.payload.response.*;
import kr.hs.entrydsm.service.Recommend.RecommendService;
import kr.hs.entrydsm.service.club.ClubPostService;
import kr.hs.entrydsm.payload.request.PostRequest;
import kr.hs.entrydsm.service.post.PostDetailService;
import kr.hs.entrydsm.service.post.PostService;
import kr.hs.entrydsm.security.JWTRequired;
import kr.hs.entrydsm.service.search.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostController {

    private final ClubPostService clubPostService;
    private final PostService postService;
    private final PostDetailService postDetailService;
    private final RecommendService recommendService;
    private final SearchService searchService;
    
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

    @GetMapping("/main/post/recommend")
    public List<RecommendResponse> entryPost() {

        return recommendService.bestPostList();

    } 
    
    @GetMapping("/main/search")

    public List<SearchResponse> getSearchList(@RequestParam("search") String searchWord) {

        return searchService.searchPostList(searchWord);
        
    }
    
}
