package kr.hs.entrydsm.service.club;

import kr.hs.entrydsm.payload.request.PostRequest;
import kr.hs.entrydsm.payload.response.PostResponse;
import kr.hs.entrydsm.payload.response.PostsResponse;

public interface ClubPostService {

    void createPost(PostRequest postRequest);

    void deletePost(long postId);

    void updatePost(long postId, PostRequest postRequest);

    PostsResponse getPosts();

    PostResponse getPost(long postId);

}
