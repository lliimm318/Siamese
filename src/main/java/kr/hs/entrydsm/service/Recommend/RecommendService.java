package kr.hs.entrydsm.service.Recommend;

import kr.hs.entrydsm.payload.response.RecommendResponse;

import java.util.List;

public interface RecommendService {

    List<RecommendResponse> bestPostList();

}
