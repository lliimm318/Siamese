package kr.hs.entrydsm.main.controller;

import kr.hs.entrydsm.main.payload.response.PageResponse;
import kr.hs.entrydsm.main.payload.response.PostResponse;
import kr.hs.entrydsm.main.service.like.LikeService;
import kr.hs.entrydsm.main.service.post.PostDetailService;
import kr.hs.entrydsm.main.service.post.PostService;
import kr.hs.entrydsm.main.payload.response.PostDetailResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/main")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    private final PostDetailService postDetailService;

    private final LikeService likeService;


    @GetMapping("/post")
    public List<PostResponse> getPosts() {

        return postService.getListPost();

    }

    @GetMapping("/post/{postId}")
    public PostDetailResponse detailPosts(@PathVariable long postId) {

        return postDetailService.getDetailPost(postId);

    }

    @PostMapping("/post/like/{postId}")
    public void like(@PathVariable long postId) {

        likeService.createLike(postId);

    }

    @GetMapping("/post/best")
    public PageResponse bestPost(Pageable page) {

        return likeService.bestPostList(page);

    }
}