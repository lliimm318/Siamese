package kr.hs.entrydsm.service.like;

import kr.hs.entrydsm.payload.response.RecommendPageResponse;
import org.springframework.data.domain.Pageable;

public interface LikeService {

    void createLike(long postId);

    RecommendPageResponse bestPostList(Pageable page);

}
