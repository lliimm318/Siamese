package kr.hs.entrydsm.service.like;

import kr.hs.entrydsm.payload.response.PageResponse;
import org.springframework.data.domain.Pageable;

public interface LikeService {

    void createLike(long postId);

    PageResponse bestPostList(Pageable page);

}
