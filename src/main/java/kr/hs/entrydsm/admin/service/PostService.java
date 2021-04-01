package kr.hs.entrydsm.admin.service;

import kr.hs.entrydsm.admin.service.dto.PostRequest;

public interface PostService {
    void createPost(PostRequest postRequest);
    void deletePost(long postId);
    void updatePost(long postId, PostRequest postRequest);
}
