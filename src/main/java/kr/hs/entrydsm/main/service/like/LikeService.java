package kr.hs.entrydsm.main.service.like;

import kr.hs.entrydsm.main.payload.response.PageResponse;

import java.awt.print.Pageable;

public interface LikeService {
    void createLike(Integer postId);
    PageResponse bestPostList(Pageable page);
}
