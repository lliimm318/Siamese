package kr.hs.entrydsm.admin.service;

import kr.hs.entrydsm.admin.service.dto.PostRequest;

public interface PostService {
    public void createPost(PostRequest postRequest);
    public void deletePost(int postId);
    public void updatePost(int postId, PostRequest postRequest);
}
