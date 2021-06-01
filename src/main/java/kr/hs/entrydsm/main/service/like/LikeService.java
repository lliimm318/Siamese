package kr.hs.entrydsm.main.service.like;

import kr.hs.entrydsm.main.payload.response.PageResponse;
import org.springframework.data.domain.Pageable;

public interface LikeService {
    void createLike(Integer postId);
    PageResponse bestPostList(Pageable page);
}
