package kr.hs.entrydsm.admin.service;

import kr.hs.entrydsm.admin.service.dto.PostRequest;
import kr.hs.entrydsm.admin.service.dto.PostResponse;
import kr.hs.entrydsm.admin.service.dto.PostsResponse;

public interface PostService {
    void createPost(PostRequest postRequest);
    void deletePost(long postId);
    void updatePost(long postId, PostRequest postRequest);
    PostsResponse getPosts();
    PostResponse getPost(long postId);
}
