package kr.hs.entrydsm.service.like;

import kr.hs.entrydsm.payload.response.RecommendResponse;

import java.util.List;

public interface LikeService {

    void createLike(long postId);

    List<RecommendResponse> bestPostList();

}
