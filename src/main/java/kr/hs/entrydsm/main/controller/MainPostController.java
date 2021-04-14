package kr.hs.entrydsm.main.controller;

import kr.hs.entrydsm.main.payload.response.PageResponse;
import kr.hs.entrydsm.main.payload.response.PostResponse;
import kr.hs.entrydsm.main.service.like.LikeService;
import kr.hs.entrydsm.main.service.post.PostDetailService;
import kr.hs.entrydsm.main.service.post.PostService;
import kr.hs.entrydsm.main.payload.response.PostDetailResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class MainPostController {

    private final PostService postService;
    private final PostDetailService postDetailService;
    private final LikeService likeService;


    @GetMapping
    public List<PostResponse> getPosts() {
        return postService.getListPost();
    }

    @GetMapping("/post/{id}")
    public PostDetailResponse detailPosts(@PathVariable Integer id) {
        return postDetailService.getDetailPost(id);
    }

    @PostMapping("/like/{postId}")
    public void like(@PathVariable Integer postId) {
        likeService.createLike(postId);
    }

    @GetMapping("/best")
    public PageResponse bestPost(Pageable page) {
        return likeService.bestPostList(page);
    }

    @GetMapping
    public void search() {

    }
}
